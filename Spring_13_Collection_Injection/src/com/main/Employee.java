package com.main;

import java.util.LinkedList;
import java.util.List;

public class Employee {
	LinkedList<Integer> workHours;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(LinkedList<Integer> workHours) {
		super();
		this.workHours = workHours;
	}

	public List<Integer> getWorkHours() {
		return workHours;
	}
	public void setWorkHours(LinkedList<Integer> workHours) {
		this.workHours = workHours;
	}

	@Override
	public String toString() {
		return "Employee [workHours = " + workHours + "]";
	}

}
