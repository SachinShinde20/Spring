package config;

public class Dog {
	static {
		System.out.println("Static Block of Dog is Called");
	}
	
	public Dog() {
		System.out.println("Dog Constructor is Called...");
	}
	
	public void bark() {
		System.out.println("Woof Woof");
	}
}
