package collectionInjection.mapInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("collectionInjection/mapInjection/beans.xml");

        Student student1 = (Student) applicationContext.getBean("student1");
        System.out.println("\nDefault Implementation: "+student1.getCourses().getClass());
        System.out.println(student1);

        Student student2 = (Student) applicationContext.getBean("student2");
        System.out.println("\nImplementation: "+student2.getCourses().getClass());
        System.out.println(student2);

        Student student3 = (Student) applicationContext.getBean("student3");
        System.out.println("\nImplementation: "+student3.getCourses().getClass());
        System.out.println(student3);
    }
}
