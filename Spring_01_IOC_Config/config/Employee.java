package config;

public class Employee {
	String name; 
	
	static {
		System.out.println("Static Block of Employee Called");
	}
	
	public Employee() {
		System.out.println("Employee Constructor is Called");
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public void showDetails() {
		System.out.println("*Employee Name: "+name);
	}
}
