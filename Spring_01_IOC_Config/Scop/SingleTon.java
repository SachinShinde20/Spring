package Scop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import config.Employee;

// Same Object is Passed in Singleton.
public class SingleTon {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/beans.xml");
        System.out.println("\tApplicationContext is Created");
		
		Employee emp1 = (Employee) applicationContext.getBean("emp1");
		emp1.showDetails();
		
		Employee emp2 = (Employee) applicationContext.getBean("emp1");
		emp2.setName("Sachin");
		emp2.showDetails();
		
		Employee emp3 = (Employee) applicationContext.getBean("emp1");
		emp3.showDetails();
		
		Employee emp4 = (Employee) applicationContext.getBean("emp1");
		emp4.showDetails();
	}
}
