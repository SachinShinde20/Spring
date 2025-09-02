package bean_Instantiation.simpleBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_Instantiation/simpleBean/beans.xml");
        Emp emp = (Emp) applicationContext.getBean("emp");
        System.out.println(emp);
    }
}
