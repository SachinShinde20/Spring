package setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("setterInjection/beans.xml");
        Employee employee = (Employee) applicationContext.getBean("emp");
        System.out.println(employee);

        Employee employee2 = (Employee) applicationContext.getBean("emp2");
        System.out.println(employee2);

    }
}
