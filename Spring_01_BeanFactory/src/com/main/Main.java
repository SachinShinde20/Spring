package com.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
	public static void main(String[] args) {

		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		System.out.println("### beanFactory is Created...");

		System.out.println("\n\t Getting e1");
		Emp e1 = (Emp) beanFactory.getBean("emp1");
		System.out.println(e1);

		System.out.println("\n\t Getting e2");
		Emp e2 = (Emp) beanFactory.getBean("emp2");
		System.out.println(e2);
	}
}
