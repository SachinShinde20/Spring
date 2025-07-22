package LazyLoading;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import config.Dog;
import config.Cat;

public class AppContext {

    public static void main(String[] args) {

    		// Note: BeanFactory does not support the Lazy Loading
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/beans.xml");
        System.out.println("\tApplicationContext is Created");
        
        boolean res = true;
        if (res) {
			Dog dog = (Dog) applicationContext.getBean("dog");
	        System.out.println("\tDog is Retrieved using ApplicationContext (Lazy-Loading)");
			dog.bark();
		} else {
			Cat cat = (Cat) applicationContext.getBean("cat");
	        System.out.println("\tCat is Retrieved using ApplicationContext (Lazy-Loading)");
			cat.meow();
 		} 
        applicationContext.close(); 
    }
}
