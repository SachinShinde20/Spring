package applicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext/beans.xml");
        System.out.println("--- Application Context is Created ---");

        Emp emp1 = (Emp) applicationContext.getBean("emp2");
        emp1.show();

        Emp emp2 = (Emp) applicationContext.getBean("emp2");
        emp2.show();

        Emp emp3 = (Emp) applicationContext.getBean("emp2");
        emp3.show();

        System.out.println("\nSingleTon Scope:");
        System.out.println(emp1 == emp2);
        System.out.println(emp2 == emp3);
        System.out.println(emp3 == emp1);
    }
}
