package config;

public class Cat {
	static {
		System.out.println("Static Block of Cat is Called");
	}
	
	public Cat() {
		System.out.println("Cat Constructor is Called...");
	}
	
	public void meow() {
		System.out.println("Meow Meow");
	}
}
