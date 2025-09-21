package com.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.main.Employee;

@Configuration
@ComponentScan(basePackages = {"com.main"})
public class MyAnnotationConfig {

	@Bean
	public Map<String, Integer> studentMarks(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Maths", 100);
		map.put("Science", 80);
		map.put("English", 90);
		return map;
	}
	
	@Bean("getTestMarks")
	public Map<String, Integer> studentMarksTest2(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Java", 100);
		map.put("Python", 80);
		map.put("C++", 90);
		return map;
	}
}
