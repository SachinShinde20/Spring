package com.main;

public class Employee {
	private int id;
	private String name;

	public Employee() {
		System.out.println("\nEmployee Bean is Created");
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("\nEmployee Bean is Created via Parameterized Constrcutor...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("Id is inserted throught Setter");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Name is inserted throught Setter");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
