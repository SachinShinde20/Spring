package com.main;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

	@PostConstruct
	public void init() {
		System.out.println("init Called...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy Called...");
	}
}
