package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("\n ### applicationContext is created \n");

		// by default singleton scope
		System.out.println("e1");
		Emp e1 = (Emp) applicationContext.getBean("emp");
		System.out.println(e1);

		System.out.println("e2");
		Emp e2 = (Emp) applicationContext.getBean("emp");
		System.out.println(e2);
	}
}