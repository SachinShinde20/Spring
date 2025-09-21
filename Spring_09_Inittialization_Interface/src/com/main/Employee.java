package com.main;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
	private int id;
	private String name;

	public Employee() {
		System.out.println("Employee Bean is Created");
	}

	@Override
	public String toString() {
		return "<Employee> Object";
	}

	// init
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init Called...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy Called...");
	}
}
