package com.controller;

public class Employee {
	private String name;
	private int age;
	private String city;
	private int salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, String city, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", city=" + city + ", salary=" + salary + "]";
	}
}
