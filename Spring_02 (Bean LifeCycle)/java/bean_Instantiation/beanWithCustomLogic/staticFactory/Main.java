package bean_Instantiation.beanWithCustomLogic.staticFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_Instantiation/beanWithCustomLogic/staticFactory/beans.xml");
        Emp emp = (Emp) applicationContext.getBean("emp");
        System.out.println(emp);
    }
}
