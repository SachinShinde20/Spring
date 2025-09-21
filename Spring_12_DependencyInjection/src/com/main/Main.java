package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("\n ...applicationContext is Created \n");

		Employee employee = (Employee) applicationContext.getBean("emp1");
		System.out.println(employee);

		employee = (Employee) applicationContext.getBean("emp2");
		System.out.println(employee);
	}
}
