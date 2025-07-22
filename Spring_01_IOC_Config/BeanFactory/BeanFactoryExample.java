package BeanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import config.Test;

public class BeanFactoryExample {

    public static void main(String[] args) {

        // Step 1: Load the XML configuration file (beans.xml) from the classpath
        Resource resource = new ClassPathResource("config/beans.xml");

        // Step 2: Create a BeanFactory object (XmlBeanFactory)
        // This is where Spring initializes the container, but NO beans are created yet (Lazy Loading)
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println("\tXmlBeanFactory is Created");

        // Step 3: Now we explicitly ask for a bean named "test1"
        // Only at this point the Test bean is actually instantiated.
        Test test = (Test) beanFactory.getBean("test1");
        System.out.println("\tObject of Test is Created using beanFactory");

        // Step 4: Call the show() method on the Test object
        test.show();
    }
}
