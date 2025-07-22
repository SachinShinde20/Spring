package config;

public class Test {
	static {
		System.out.println("Static Block is Callled...");
	}
	
	{
		System.out.println("Test's Instance Method is Called...");
	}
	
	public Test() {
		System.out.println("Test Constructor is Callled...");
	}
	
	public void show() {
		System.out.println("Show Method is Called...");
	}
}
