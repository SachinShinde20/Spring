package constructorInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructorInjection/beans.xml");
        Employee employee1 = (Employee) applicationContext.getBean("emp1");
        System.out.println("\n"+employee1);

        Employee employee2 = (Employee) applicationContext.getBean("emp2");
        System.out.println(employee2);

        Employee employee3 = (Employee) applicationContext.getBean("emp3");
        System.out.println(employee3);
    }
}
