package com.main;

public class Employee {
	private int id;
	private String name;

	public Employee() {
		System.out.println("Employee Bean is Created");
	}

	@Override
	public String toString() {
		return "<Employee> Object";
	}

	public void init() {
		System.out.println("init Called...");
	}

	public void destroy() {
		System.out.println("destroy Called...");
	}
}
