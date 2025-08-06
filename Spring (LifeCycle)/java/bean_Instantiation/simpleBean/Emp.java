package bean_Instantiation.simpleBean;

public class Emp {
    Emp(){
        System.out.println("\tEmp is Created...");
    }

    @Override
    public String toString() {
        return " --- Emp Class toString() --- ";
    }
}
