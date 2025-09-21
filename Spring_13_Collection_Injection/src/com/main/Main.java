package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("...applicationContext is Created");
		
//		Employee employee = (Employee) applicationContext.getBean("emp1");
//		System.out.println(employee);
//		System.out.println(employee.getWorkHours().getClass().getName()); 
		
//		Employee employee = (Employee) applicationContext.getBean("emp2");
//		System.out.println(employee);
//		System.out.println(employee.getWorkHours().getClass().getName()); 
		
		Employee employee = (Employee) applicationContext.getBean("emp3");
		System.out.println(employee);
		System.out.println(employee.getWorkHours().getClass().getName()); 
	}
}
