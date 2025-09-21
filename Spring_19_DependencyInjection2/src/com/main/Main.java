package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.config.MyAnnotationConfig;

public class Main {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAnnotationConfig.class);
		System.out.println("\n--- applicationContext is Created ---\n");
		
		Employee emp1 = applicationContext.getBean(Employee.class);
		System.out.println(emp1);
	}
}
