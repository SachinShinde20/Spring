package bean_Instantiation.beanWithCustomLogic.separationConcerns;

public class ObjectFactory {
    public static Emp getEmpObject(){
        Emp emp = new Emp();
        emp.setId((int)(Math.random()*1000));
        emp.setName("Sachin");
        System.out.println("Emp Object is Created via Separation of Concerns, using Static Factory Method and Custom Logic.");
        return emp;
    }
}
