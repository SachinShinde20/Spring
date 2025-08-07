package setterInjection;

public class Employee {
    private int id;
    private String name;
    private String address;
    private long mobileNo;

    Employee(){
        super();
        System.out.println("\nEmployee default constructor is called...");
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("Employee id is inserted.");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Employee name is inserted.");

    }

    public void setAddress(String address) {
        this.address = address;
        System.out.println("Employee address is inserted.");

    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
        System.out.println("Employee mobile number is inserted.");
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
