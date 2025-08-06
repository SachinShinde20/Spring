package bean_Instantiation.beanWithCustomLogic.separationConcerns;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_Instantiation/beanWithCustomLogic/separationConcerns/beans.xml");
        Emp emp = (Emp) applicationContext.getBean("emp");
        System.out.println(emp);
    }
}
