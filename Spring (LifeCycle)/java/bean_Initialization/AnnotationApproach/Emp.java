package bean_Initialization.AnnotationApproach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    @PostConstruct
    public void init(){
        System.out.println("\tInitializing Object through annotation approach...");
        System.out.println("\tRenaming "+name+" to "+ "Hello");
        name = "Hello";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("\tDeallocation Resources through annotation approach...");
    }
}
