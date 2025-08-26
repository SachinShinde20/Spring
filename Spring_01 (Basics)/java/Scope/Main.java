package Scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Scope/beans.xml");
        System.out.println("---- applicationContext is Created ---");

        Product product1 = (Product) applicationContext.getBean("product");
        product1.show();

        Product product2 = (Product) applicationContext.getBean("product");
        product2.show();

        Product product3 = (Product) applicationContext.getBean("product");
        product3.show();


        System.out.println("\nScope Checking:");
        System.out.println(product1 == product2);
        System.out.println(product2 == product3);
        System.out.println(product3 == product1);
    }
}

/*
Default Output (Default: SingleTon):
Product Obj is Created...
        ---- applicationContext is Created ---
Show called..
Show called..
Show called..
*/
