import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("\nUsing Setter injection");
        Employee employee = (Employee) applicationContext.getBean("emp");
        System.out.println(employee);

        Manager manager = (Manager) applicationContext.getBean("manager");
        System.out.println(manager);

        System.out.println("\nUsing Constructor injection");
        Employee employee2 = (Employee) applicationContext.getBean("emp2");
        System.out.println(employee2);

        Manager manager2 = (Manager) applicationContext.getBean("manager2");
        System.out.println(manager2);
    }
}
