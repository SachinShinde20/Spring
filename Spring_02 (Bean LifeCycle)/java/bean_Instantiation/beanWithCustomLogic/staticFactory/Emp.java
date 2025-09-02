package bean_Instantiation.beanWithCustomLogic.staticFactory;

public class Emp {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Emp getEmpObject(){
        Emp emp = new Emp();
        emp.setId((int) (Math.random()*1000));
        emp.setName("Sachin");
        System.out.println("Emp Object is Created, using Static Factory Method and Custom Logic.");
        return emp;
    }
}
