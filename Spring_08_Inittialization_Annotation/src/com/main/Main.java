package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("\n...applicationContext is Created \n");

		Employee employee = (Employee) applicationContext.getBean("emp");
		System.out.println(employee);

		applicationContext.close();
		System.out.println("\n...applicationContext is Closed");
	}
}
