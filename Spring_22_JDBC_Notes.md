# 1) How exception handling works (big picture)

- **Throwing**: some code detects an error and `throw`s an exception (`throw new IOException(...)`).
- **Propagation / stack unwinding**: if not caught where thrown, the exception bubbles up the call stack until a matching `catch` is found. While bubbling, each method’s local state is discarded.
- **Catching**: a `try { ... } catch (SpecificException e) { ... }` block handles the problem.
- **Finally**: `finally { ... }` always runs (even after `return`) — used for cleanup when you can't use try-with-resources.
- **Try-with-resources**: `try (AutoCloseable r = ...) {}` automatically closes resources and handles suppressed exceptions cleanly.

# 2) Checked vs. unchecked (why it matters)

- **Checked exceptions** (e.g. `IOException`, `SQLException`) must be declared or handled. They represent recoverable conditions.
- **Unchecked exceptions** (`RuntimeException` and subclasses) are programming errors (e.g. `NullPointerException`, `IllegalArgumentException`) or framework-wrapped runtime exceptions (Spring’s `DataAccessException`).

---

- In Spring JDBC, raw `SQLException` is wrapped by Spring into **`DataAccessException`** (a runtime exception). That means you often catch `DataAccessException` rather than `SQLException`.

# 3) Core constructs and idioms (with mini examples)

**Basic try/catch**

```java
try {
    // risky operation
} catch (SpecificException ex) {
    logger.error("message", ex);
    // handle or translate
}
```

**Try-with-resources (preferred for AutoCloseable)**

```java
try (Scanner sc = new Scanner(System.in)) {
    // sc closed automatically
}
```

**Return Optional instead of throwing for “not found”**

```java
public Optional<Employee> findById(int id) {
    try {
        Employee e = jdbcTemplate.queryForObject(...);
        return Optional.of(e);
    } catch (EmptyResultDataAccessException ex) {
        return Optional.empty();
    }
}
```

**Catching framework exceptions and wrapping them**

```java
try {
   jdbcTemplate.update(...);
} catch (DataAccessException ex) {
   logger.error("DB failed", ex);
   throw new RepositoryException("persist failed", ex); // custom runtime
}
```

# 4) How I used exceptions in your refactor — reasoning & improvements

From the refactor I gave you earlier, the goals were:

- Don’t use exceptions as _normal control flow_. (E.g., don’t rely on an exception to mean “no record”. Prefer `Optional` or `queryForList()`.)
- Catch **specific** exceptions when you can (e.g. `EmptyResultDataAccessException` for “not found”), and catch `DataAccessException` for DB-level unexpected issues.
- **Log** errors (use SLF4J) instead of `printStackTrace()`; return safe default values or rethrow a domain-level exception.
- Use try-with-resources for the `AnnotationConfigApplicationContext` and `Scanner` (so resources are always closed).
- Keep exception handling at the **right layer**: the DAO translates low-level DB exceptions into repository exceptions; the service layer enforces business rules and may map exceptions to domain exceptions; controller / API layer maps domain exceptions to HTTP responses.

Note: in my earlier refactor I had a small inconsistency — I both caught `EmptyResultDataAccessException` and used a `getEmployeeById()` that already returned `null`. Better: make `findById()` return `Optional` and check that. I’ll show that below.

# 5) Practical, industry patterns with code (copy/paste)

### a) Custom exceptions (domain & repository)

```java
// in com.exception
public class RepositoryException extends RuntimeException {
    public RepositoryException(String msg, Throwable cause) { super(msg, cause); }
}

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) { super(msg); }
}

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String msg) { super(msg); }
}
```

### b) DAO using Optional + proper catches + SLF4J

```java
package com.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dto.Employee;
import com.exception.RepositoryException;

@Repository
public class EmployeeDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
    private final JdbcTemplate jdbc;

    public EmployeeDao(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public Optional<Employee> findById(int id) {
        try {
            Employee e = jdbc.queryForObject(
                "SELECT * FROM employees WHERE employee_id = ?",
                new EmployeeRowMapper(), id);
            return Optional.of(e);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty(); // normal: not found
        } catch (DataAccessException ex) {
            logger.error("DB error on findById({})", id, ex);
            throw new RepositoryException("DB failure fetching employee", ex);
        }
    }

    public void insertEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("employee required");
        if (findById(employee.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("Employee exists: " + employee.getId());
        }
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, department, salary) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbc.update(sql, employee.getId(), employee.getFirstName(),
                        employee.getLastname(), employee.getDept(), employee.getSalary());
            logger.info("Inserted {}", employee);
        } catch (DataAccessException ex) {
            logger.error("Failed to insert {}", employee, ex);
            throw new RepositoryException("Failed to insert employee", ex);
        }
    }

    public List<Map<String, Object>> findAll() {
        try {
            return jdbc.queryForList("SELECT * FROM employees");
        } catch (DataAccessException ex) {
            logger.error("Failed to fetch all employees", ex);
            throw new RepositoryException("DB failure fetching employees", ex);
        }
    }
}
```

### c) Service layer with transactions & throwing domain exceptions

```java
@Service
public class EmployeeService {
    private final EmployeeDao dao;

    @Autowired
    public EmployeeService(EmployeeDao dao) { this.dao = dao; }

    @Transactional // rollback on runtime exceptions by default
    public void createEmployee(Employee emp) {
        // validate business rules
        if (emp.getSalary() < 0) throw new IllegalArgumentException("negative salary");
        dao.insertEmployee(emp);
    }
}
```

**Note:** If you want rollback on a checked exception, use `@Transactional(rollbackFor = MyCheckedException.class)`.

### d) ControllerAdvice: map exceptions to HTTP responses (Spring MVC)

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body(Map.of("status", 404, "message", ex.getMessage()));
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Map<String,Object>> handleConflict(EntityAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
               .body(Map.of("status", 409, "message", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleAll(Exception ex) {
        logger.error("Unhandled exception", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body(Map.of("status", 500, "message", "Internal server error"));
    }
}
```

# 6) Best practices checklist (short)

- Catch the **most specific** exception you can.
- Don’t catch `Exception` unless you will log + rethrow or return an appropriate fallback.
- **Don’t swallow** exceptions (i.e., avoid `catch (Exception e) {}` with no action).
- Use **Optional** or queryForList to express “not found”, rather than exceptions for normal control flow.
- **Log** details (stack trace) with logger, but return safe, non-sensitive messages to API callers.
- Use **custom domain exceptions** to separate persistence errors vs business rule failures.
- Use **try-with-resources** for AutoCloseable resources.
- Prefer rethrowing wrapped exceptions (preserve cause): `throw new RepositoryException("msg", ex)`.
- Know **transaction semantics**: unchecked exceptions cause rollback by default in Spring.
- Write unit tests for exception paths (use `assertThrows`).

---

---

---

# 🔹 What is a Transaction?

- A **transaction** is a group of database operations that either **all succeed** or **all fail**.
- Classic example: transfer money from A → B

  - Debit A’s account
  - Credit B’s account
  - If credit fails, debit must also roll back.

Without transactions → inconsistent data.

---

# 🔹 How Spring handles Transactions

Spring uses the concept of **transaction boundaries**:

- Start → do DB work → Commit (if success) → Rollback (if failure).
- Managed by **PlatformTransactionManager**.
- With **Spring JDBC**, that’s `DataSourceTransactionManager`.
- In practice: you don’t need to manage it manually → just use `@Transactional`.

---

# 🔹 Using `@Transactional` (simplest way)

Add **Spring TX dependency** (already in Spring Boot starter JDBC).
Then annotate your **service methods** with `@Transactional`.

```java
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    // Transaction boundary: starts before method, commits if success, rolls back if runtime exception
    @Transactional
    public void giveSalaryRaise(int id, int raiseAmount) {
        var empOpt = employeeDao.findById(id);
        if (empOpt.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        Employee emp = empOpt.get();
        int newSalary = emp.getSalary() + raiseAmount;

        employeeDao.updateSalary(id, newSalary);

        // If another DB call here fails → whole transaction is rolled back
    }
}
```

👉 By default:

- Transaction **commits** if method completes successfully.
- Transaction **rolls back** if a **runtime exception** (unchecked) is thrown.
- Checked exceptions (like `IOException`) don’t cause rollback unless you configure it.

---

# 🔹 Customizing Rollback

```java
@Transactional(rollbackFor = Exception.class) // rollback even for checked exceptions
public void riskyOperation() throws Exception {
    // DB operations
    if (true) throw new Exception("oops");
    // rollback happens because of rollbackFor
}
```

---

## 🔹 What is “Propagation”?

Propagation means: _if one method with `@Transactional` calls another method with `@Transactional`, how should Spring handle the transaction?_

Should the second method **join the first one’s transaction**, or should it **start its own independent transaction**?

---

## 1) `REQUIRED` (default)

👉 “If a transaction exists, join it. If not, create a new one.”

```java
@Service
public class EmployeeService {

    @Transactional // starts a transaction
    public void outerMethod() {
        dao.insertEmployee(new Employee(1, "Alice", "IT", "HR", 50000));
        innerMethod(); // joins the SAME transaction
    }

    @Transactional // will join the same transaction
    public void innerMethod() {
        dao.insertEmployee(new Employee(2, "Bob", "IT", "HR", 60000));
        // if this fails, both Alice and Bob are rolled back
    }
}
```

✅ Result: If `innerMethod()` fails → `outerMethod()` also rolls back.
Because both run in **one transaction**.

---

## 2) `REQUIRES_NEW`

👉 “Always start a new transaction, suspending the old one.”

```java
@Service
public class EmployeeService {

    @Transactional
    public void outerMethod() {
        dao.insertEmployee(new Employee(3, "Charlie", "Finance", 70000));

        try {
            innerMethod(); // runs in a NEW transaction
        } catch (Exception e) {
            System.out.println("Inner failed, but outer continues");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void innerMethod() {
        dao.insertEmployee(new Employee(3, "David", "Finance", 80000)); // duplicate ID → fail
    }
}
```

✅ Result:

- Inner transaction fails → **rolled back**.
- Outer transaction is independent → **commits successfully**.

So **Charlie is saved, David is not**.

---

## 3) `MANDATORY`

👉 “Must run inside a transaction. If no transaction exists → throw error.”

```java
@Transactional(propagation = Propagation.MANDATORY)
public void mustBeInTransaction() {
    dao.insertEmployee(new Employee(4, "Eve", "HR", 90000));
}
```

✅ Result:

- If you call this method **without an active transaction**, Spring throws an exception.
- If you call it from another `@Transactional` method, it works.

---

## 4) `SUPPORTS`

👉 “If a transaction exists, join it. If not, just run without a transaction.”

```java
@Transactional(propagation = Propagation.SUPPORTS)
public void flexibleMethod() {
    dao.insertEmployee(new Employee(5, "Frank", "Sales", 40000));
}
```

✅ Result:

- If called inside another `@Transactional` method → joins that transaction.
- If called alone → runs without a transaction.

---

# 🔑 Easy analogy

- **REQUIRED** → “If my friend is driving, I’ll join his car. If not, I’ll drive my own car.”
- **REQUIRES_NEW** → “I always drive my own car, even if my friend has one.”
- **MANDATORY** → “I refuse to go unless I can ride in my friend’s car.”
- **SUPPORTS** → “If my friend has a car, I’ll ride with him. If not, I’ll walk.”

---

👉 So, most of the time you’ll just use **REQUIRED** (default).
You only use `REQUIRES_NEW`, `MANDATORY`, or `SUPPORTS` in special cases.
