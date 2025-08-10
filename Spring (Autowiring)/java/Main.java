import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);

        Student student2 = (Student) applicationContext.getBean("student2");
        System.out.println(student2);

        Student student3 = (Student) applicationContext.getBean("student3");
        System.out.println(student3);

        Student student4 = (Student) applicationContext.getBean("student4");
        System.out.println(student4);
    }
}
