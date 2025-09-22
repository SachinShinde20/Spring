package com.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Crud {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("JdbcTemplate is ready!");
	}

	public void insertData(int id, String fn, String ln, String dept, int salary) {
		String sql = "INSERT INTO employees (employee_id, first_name, last_name, department, salary) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, id, fn, ln, dept, salary);
		System.out.println("Inserted: " + id);
	}

	public void updateData(int id, int salary) {
		jdbcTemplate.update("UPDATE employees SET salary=? WHERE employee_id=?", salary, id);
		System.out.println("Updated salary for ID " + id);
	}

	public void deleteData(int id) {
		jdbcTemplate.update("DELETE FROM employees WHERE employee_id=?", id);
		System.out.println("Deleted ID " + id);
	}

	public List<Map<String, Object>> readAll() {
		return jdbcTemplate.queryForList("SELECT * FROM employees");
	}

	public List<Employee> readBySalary(int salary) {
		return jdbcTemplate.query("SELECT * FROM employees WHERE salary > ?", new EmpRowMapperImp(), salary);
	}

	public Employee readOne(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE employee_id=?", new EmpRowMapperImp(), id);
	}

	public void deleteTableRecords() {
		jdbcTemplate.update("TRUNCATE TABLE employees");
		System.out.println("All records deleted.");
	}
}
