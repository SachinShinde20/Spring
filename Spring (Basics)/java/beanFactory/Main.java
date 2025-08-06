package beanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

        Resource resource = new ClassPathResource("beanFactory/beans.xml");
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println("--- Bean Factory is Created ---");

        Emp emp1 = (Emp) beanFactory.getBean("emp1");
        emp1.show();

        Emp emp2 = (Emp) beanFactory.getBean("emp1");
        emp2.show();

        Emp emp3 = (Emp) beanFactory.getBean("emp1");
        emp3.show();

        System.out.println("\nSingleTon Scope:");
        System.out.println(emp1 == emp2);
        System.out.println(emp2 == emp3);
        System.out.println(emp3 == emp1);
    }
}
