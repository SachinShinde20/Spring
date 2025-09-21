package com.main;

public class Emp {
	private int id;
	private String name;
	private String city;

	public Emp() {
		super();
		System.out.println("Emp is created Using Default Constructor");
	}

	public Emp(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		System.out.println("Emp is created Using Parameterized Constructor");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("Id is inserted using setter...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Name is inserted using setter...");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		System.out.println("City is inserted using setter...");
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	// User for the Custom Logic....
	public static Emp getEmp() {
		System.out.println("Custom Logic is Executing...");

		Emp emp = new Emp(101, "Raj", "Mumbai");
		// or through setter
		return emp;
	}
}