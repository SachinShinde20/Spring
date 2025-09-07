package constructorInjection;

public class Employee {
    private int id;
    private String name;
    private String address;
    private long mobileNo;

    Employee() {
        super();
        System.out.println("\nEmployee default constructor is called...");
    }

    public Employee(int id, String name, String address, long mobileNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
        System.out.println("\n--- Constructor 1 ---");
        System.out.println("[int, java.lang.String, java.lang.String, long]");
    }

    public Employee(String id, String name, String address, String mobileNo) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.address = address;
        this.mobileNo = Long.parseLong(mobileNo);
        System.out.println("\n--- Constructor 2 ---");
        System.out.println("[java.lang.String, java.lang.String, java.lang.String, java.lang.String]");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
