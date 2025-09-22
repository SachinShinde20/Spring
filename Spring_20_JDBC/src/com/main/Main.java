package com.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
				Scanner scanner = new Scanner(System.in)) {

			Crud crud = ctx.getBean(Crud.class);

			while (true) {
				System.out.println("\n=== Employee Menu ===");
				System.out.println("1. Insert a New Employee");
				System.out.println("2. Update an Employee's Salary");
				System.out.println("3. Delete an Employee");
				System.out.println("4. Show All Employees");
				System.out.println("5. Show Employees Above Salary");
				System.out.println("6. Show Single Employee");
				System.out.println("7. Truncate Table");
				System.out.println("8. Exit");

				int choice = scanner.nextInt();
				scanner.nextLine(); // consume newline

				switch (choice) {
				case 1 -> {
					System.out.print("ID: ");
					int id = scanner.nextInt();
					scanner.nextLine(); // consume newline

					System.out.print("First Name: ");
					String fn = scanner.nextLine();

					System.out.print("Last Name: ");
					String ln = scanner.nextLine();

					System.out.print("Department: ");
					String dept = scanner.nextLine();

					System.out.print("Salary: ");
					int sal = scanner.nextInt();

					crud.insertData(id, fn, ln, dept, sal);
				}
				case 2 -> {
					System.out.print("ID: ");
					int id = scanner.nextInt();

					System.out.print("New Salary: ");
					int sal = scanner.nextInt();

					crud.updateData(id, sal);
				}
				case 3 -> {
					System.out.print("ID: ");
					int id = scanner.nextInt();

					crud.deleteData(id);
				}
				case 4 -> {
					List<Map<String, Object>> dataList = crud.readAll();
					for (Map<String, Object> map : dataList) {
						System.out.println(map);
					}
				}
				case 5 -> {
					System.out.print("Min Salary: ");
					int sal = scanner.nextInt();
					List<Employee> data = crud.readBySalary(sal);
					for (Employee employee : data) {
						System.out.println(employee);
					}
				}
				case 6 -> {
					System.out.print("ID: ");
					int id = scanner.nextInt();
					System.out.println(crud.readOne(id));
				}
				case 7 -> crud.deleteTableRecords();
				case 8 -> {
					System.out.println("Bye!");
					return;
				}
				default -> System.out.println("Invalid choice.");
				}
			}
		}
	}
}