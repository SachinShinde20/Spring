package bean_Initialization.interfaceApproach;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Emp implements InitializingBean, DisposableBean {

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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\tInitializing Object through interface...");
        System.out.println("\tRenaming "+name+" to "+ "Hello");
        name = "Hello";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("\tDeallocation Resources through interface...");
    }
}
