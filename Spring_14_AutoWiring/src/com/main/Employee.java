package com.main;

import java.util.List;

public class Employee {
	private int id;
	private List<String> workHour;
	
	public Employee() {
		super();
		System.out.println("Constructor Called 1...");
	}
	public Employee(List<String> workHour) {
		super();
		this.workHour = workHour;
		System.out.println("Constructor Called 2...");
	}
	public Employee(int id, List<String> workHour) {
		super();
		this.id = id;
		this.workHour = workHour;
		System.out.println("Constructor Called 3...");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		System.out.println("Setting id");
	}
	public List<String> getWorkHour() {
		return workHour;
	}
	public void setWorkHour(List<String> workHour) {
		this.workHour = workHour;
		System.out.println("Setting workHours");
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", workHour=" + workHour + "]";
	}
}
