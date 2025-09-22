package com.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.configuration.MyConfiguration;
import com.dao.CrudApp;
import com.dto.Employee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		CrudApp crudApp = context.getBean(CrudApp.class);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Inserting initial sample data... ");
		crudApp.insertSampleData();

		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("\n--- Employee Operations Menu ---");
			System.out.println("1. Insert an Employee");
			System.out.println("2. Update an Employee's Salary");
			System.out.println("3. Delete an Employee");
			System.out.println("4. Get All Employees");
			System.out.println("5. Get Employee by ID");
			System.out.println("6. Get Employees with Salary Greater Than a Value");
			System.out.println("7. Clear All Records");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline left-over

				switch (choice) {
				case 1:
					// Insert an Employee
					System.out.println("Enter Employee ID: ");
					int newId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter First Name: ");
					String newFirstName = scanner.nextLine();
					System.out.println("Enter Last Name: ");
					String newLastName = scanner.nextLine();
					System.out.println("Enter Department: ");
					String newDept = scanner.nextLine();
					System.out.println("Enter Salary: ");
					int newSalary = scanner.nextInt();
					scanner.nextLine();
					Employee newEmployee = new Employee(newId, newFirstName, newLastName, newDept, newSalary);
					crudApp.insertEmployee(newEmployee);
					break;
				case 2:
					// Update an Employee's Salary
					System.out.println("Enter Employee ID to update salary: ");
					int updateId = scanner.nextInt();
					System.out.println("Enter new salary: ");
					int updatedSalary = scanner.nextInt();
					scanner.nextLine();
					crudApp.updateSalary(updateId, updatedSalary);
					break;
				case 3:
					// Delete an Employee
					System.out.println("Enter Employee ID to delete: ");
					int deleteId = scanner.nextInt();
					scanner.nextLine();
					crudApp.deleteEmployee(deleteId);
					break;
				case 4:
					// Get All Employees
					System.out.println("\nAll Employees:");
					crudApp.getAllEmployees().forEach(System.out::println);
					break;
				case 5:
					// Get Employee by ID
					System.out.println("Enter Employee ID to get details: ");
					int searchId = scanner.nextInt();
					scanner.nextLine();
					Employee foundEmployee = crudApp.getEmployeeById(searchId);
					if (foundEmployee != null) {
						System.out.println("Employee Found: " + foundEmployee);
					} else {
						System.out.println("Employee with ID " + searchId + " not found.");
					}
					break;
				case 6:
					// Get Employees with Salary Greater Than a Value
					System.out.println("Enter a salary value: ");
					int salaryThreshold = scanner.nextInt();
					scanner.nextLine();
					List<Employee> employees = crudApp.getEmployeesWithSalaryGreaterThan(salaryThreshold);
					System.out.println(employees);
					break;
				case 7:
					// Clear All Records
					crudApp.clearAllRecords();
					break;
				case 8:
					// Exit
					continueLoop = false;
					System.out.println("Exiting application. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 8.");
					break;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine(); // Clear the invalid input from the scanner
			}
		}
		scanner.close();
		((AnnotationConfigApplicationContext) context).close();
	}
}