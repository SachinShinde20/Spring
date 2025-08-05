package lazyLoading;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("lazyLoading/beans.xml");
        System.out.println("--- applicationContext is Created ---");

        if(true){
            Happy happy = (Happy) applicationContext.getBean("happy");
            System.out.println(happy);
        }else {
            Bunny bunny = (Bunny) applicationContext.getBean("bunny");
            System.out.println(bunny);
        }
    }
}
