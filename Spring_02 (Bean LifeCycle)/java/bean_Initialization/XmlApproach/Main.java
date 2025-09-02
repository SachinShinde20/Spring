package bean_Initialization.XmlApproach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_Initialization/XmlApproach/beans.xml");
        Emp emp = (Emp) applicationContext.getBean("emp");
        System.out.println(emp);

        // Destroy method will be called before the applicationContext is closed.
        applicationContext.close();
    }
}
