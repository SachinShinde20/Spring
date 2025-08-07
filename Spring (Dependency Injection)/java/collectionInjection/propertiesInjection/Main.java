package collectionInjection.propertiesInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("collectionInjection/propertiesInjection/beans.xml");

        Emp emp = (Emp) applicationContext.getBean("emp");
        System.out.println(emp);

        Emp employee = (Emp) applicationContext.getBean("employee");
        System.out.println(employee);
    }
}
