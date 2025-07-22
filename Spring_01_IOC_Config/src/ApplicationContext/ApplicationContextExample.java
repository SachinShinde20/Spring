package ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import config.Test;

public class ApplicationContextExample {

    public static void main(String[] args) {

        // Create an ApplicationContext container using XML configuration file
        // Unlike BeanFactory, ApplicationContext performs eager loading,
        // so all singleton beans are created as soon as the context is initialized
        ClassPathXmlApplicationContext applicationContext = 
                new ClassPathXmlApplicationContext("config/beans.xml");

        System.out.println("\tApplicationContext is Created");

        // Step 2: Fetching the 'test' bean from the Spring container
        Test test = (Test) applicationContext.getBean("test1");

        System.out.println("\tObject of Test is Retrieved using ApplicationContext");

        // Step 3: Call method on bean
        test.show();

        // Step 4: Close the context to release resources
        applicationContext.close(); 
    }
}
