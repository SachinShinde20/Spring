package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee employee = (Employee) applicationContext.getBean("emp1");
		System.out.println(employee);
		
	}
}
