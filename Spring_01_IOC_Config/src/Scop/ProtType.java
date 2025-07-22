package Scop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.Employee;

// Different Object is Passed in Prototype (Always: Lazy-Loaded).
public class ProtType {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/beans.xml");
		
        System.out.println("\tApplicationContext is Created");
		
		Employee emp1 = (Employee) applicationContext.getBean("emp2");
		emp1.setName("Sachin");
		emp1.showDetails();
		
		Employee emp2 = (Employee) applicationContext.getBean("emp2");
		emp2.showDetails();
		
		Employee emp3 = (Employee) applicationContext.getBean("emp2");
		emp3.setName("Raj");
		emp3.showDetails();
	}
}
