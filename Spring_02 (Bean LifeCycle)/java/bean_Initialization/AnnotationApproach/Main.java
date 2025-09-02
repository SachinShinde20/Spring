package bean_Initialization.AnnotationApproach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_Initialization/AnnotationApproach/beans.xml");
        Emp emp = (Emp) applicationContext.getBean("emp");
        System.out.println(emp);

        applicationContext.close();
    }
}
