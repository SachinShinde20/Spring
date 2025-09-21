package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("\n### applicationContext is created.");

		System.out.println("\n\t Getting e1");
		Emp e1 = (Emp) applicationContext.getBean("emp1");
		System.out.println(e1);

		System.out.println("\n\t Getting e2");
		Emp e2 = (Emp) applicationContext.getBean("emp1");
		System.out.println(e2);

		// Checking weather object is same.
		System.out.println("\n### Result: " + (e1 == e2));

		System.out.println("\n\t Getting e3");
		Emp e3 = (Emp) applicationContext.getBean("emp2");
		System.out.println(e3);

		System.out.println("\n\t Getting e4");
		Emp e4 = (Emp) applicationContext.getBean("emp2");
		System.out.println(e4);

		// Checking weather object is same.
		System.out.println("\n### Result: " + (e3 == e4));
	}
}