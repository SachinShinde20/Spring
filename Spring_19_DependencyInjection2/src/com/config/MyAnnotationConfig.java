package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.main")
@PropertySource("classpath:com/config/MyDetails.properties")
public class MyAnnotationConfig{
	
}
