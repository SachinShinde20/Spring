package bean_Instantiation.staticDependency;

public class Emp {
    int id;
    String name;

    Emp(){
        super();
        System.out.println("Using Default Constructor...");
    }

    //Constructor
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Using Parameterized Constructor...");
    }

    // Setter
    public void setId(int id) {
        this.id = id;
        System.out.println("Using Setter to insert id...");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Using Setter to insert name...");
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
