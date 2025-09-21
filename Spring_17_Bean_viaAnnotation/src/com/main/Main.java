package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.MyAnnotationConfig;

public class Main {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MyAnnotationConfig.class);
		System.out.println("\n--- applicationContext is Created ---\n");

//		Employee emp1 = applicationContext.getBean(Employee.class);
//		emp1.show();					for @Component // -> No Need to Cast

		Employee emp2 = (Employee) applicationContext.getBean("emp");
		emp2.show();

		Employee emp3 = (Employee) applicationContext.getBean("empBean");
		emp3.show();

		Employee emp4 = (Employee) applicationContext.getBean("getEmployeeObject");
		emp4.show();
	}
}
