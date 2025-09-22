package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dto.Employee;

@Component
@Lazy
public class CrudApp {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertSampleData() {
		insertEmployee(new Employee(101, "Alice", "Johnson", "Marketing", 65000));
		insertEmployee(new Employee(102, "Bob", "Williams", "Engineering", 90000));
		insertEmployee(new Employee(103, "Charlie", "Brown", "Sales", 72000));
		insertEmployee(new Employee(104, "Diana", "Miller", "HR", 55000));
		insertEmployee(new Employee(105, "Edward", "Davis", "IT", 85000));
	}

	public void insertEmployee(Employee employee) {
		try {
			Employee existing = getEmployeeById(employee.getId());
			if (existing != null) {
				System.out.println("Error: Employee with ID " + employee.getId() + " already exists.");
				return;
			}
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Something Went Wrong:");
			e.printStackTrace();
		}

		String sql = "INSERT INTO employees (employee_id, first_name, last_name, department, salary) VALUES (?, ?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastname(),
					employee.getDept(), employee.getSalary());
			System.out.println("Inserted Employee: " + employee);
		} catch (DataAccessException e) {
			System.err.println("Error inserting employee: " + e.getMessage());
		}
	}

	public void updateSalary(int id, int salary) {
		try {
			int updated = jdbcTemplate.update("UPDATE employees SET salary=? WHERE employee_id=?", salary, id);
			if (updated > 0) {
				System.out.println("Updated salary for Employee ID: " + id);
			} else {
				System.out.println("No Employee found with ID " + id);
			}
		} catch (DataAccessException e) {
			System.err.println("Error updating salary: " + e.getMessage());
		}
	}

	public void deleteEmployee(int id) {
		try {
			int deleted = jdbcTemplate.update("DELETE FROM employees WHERE employee_id=?", id);
			if (deleted > 0) {
				System.out.println("Deleted Employee with ID: " + id);
			} else {
				System.out.println("No Employee found with ID " + id);
			}
		} catch (DataAccessException e) {
			System.err.println("Error deleting employee: " + e.getMessage());
		}
	}

	public List<Map<String, Object>> getAllEmployees() {
		try {
			return jdbcTemplate.queryForList("SELECT * FROM employees");
		} catch (DataAccessException e) {
			System.err.println("Error fetching employees: " + e.getMessage());
			return List.of();
		}
	}

	public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
		try {
			return jdbcTemplate.query("SELECT * FROM employees WHERE salary > ?", new EmployeeRowMapper(), salary);
		} catch (DataAccessException e) {
			System.err.println("Error fetching employees by salary: " + e.getMessage());
			return List.of();
		}
	}

	public Employee getEmployeeById(int id) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE employee_id=?", new EmployeeRowMapper(),
					id);
		} catch (EmptyResultDataAccessException e) {
			return null; // Employee not found
		} catch (DataAccessException e) {
			System.err.println("Error fetching employee: " + e.getMessage());
			return null;
		}
	}

	public void clearAllRecords() {
		try {
			jdbcTemplate.update("TRUNCATE TABLE employees");
			System.out.println("All records deleted.");
		} catch (DataAccessException e) {
			System.err.println("Error clearing employees table: " + e.getMessage());
		}
	}
}
