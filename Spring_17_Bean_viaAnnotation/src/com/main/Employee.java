package com.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Component("emp")
//@Lazy
@Scope("prototype")
public class Employee {
	public Employee() {
		System.out.println("Employee is Created...");
	}

	public void show() {
		System.out.println("Show Called...\t\t" + this);
	}
}
