package bean_Initialization.XmlApproach;

public class Emp {
    int id;
    String name;

    public Emp() {
        super();
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    //init() -> Name can be anything
    public void init(){
        System.out.println("\tInitializing Object Using Xml...");
        System.out.println("\tRenaming "+name+" to "+ "Xyz");
        name = "Xyz";
    }

    //destroy() -> Name can be anything
    public void destroy(){
        System.out.println("\tDeallocation Resources Using Xml...");
    }
}
