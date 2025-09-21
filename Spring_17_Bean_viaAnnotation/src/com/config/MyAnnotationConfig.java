package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.main.Employee;

@Configuration
@ComponentScan(basePackages = { "com.main" })
public class MyAnnotationConfig {

	@Bean("empBean")
	// @Lazy
	@Scope("prototype")
	public Employee getEmployee() {
		System.out.println("Creating custom Object...");
		return new Employee();
	}
}
