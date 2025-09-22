package com.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.main")
@PropertySource("com/main/DB-Details.properties")
public class SpringBeanConfig {
	Environment environment;

	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
		System.out.println("environment is set");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("db-url"));
		dataSource.setUsername(environment.getProperty("db-user"));
		dataSource.setPassword(environment.getProperty("db-password"));
		dataSource.setDriverClassName(environment.getProperty("db-driver"));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		// Spring will call this like:
		// return new JdbcTemplate(applicationContext.getBean(DataSource.class));
		return new JdbcTemplate(dataSource);
	}
}
