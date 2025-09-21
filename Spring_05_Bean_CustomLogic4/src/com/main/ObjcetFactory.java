package com.main;

public class ObjcetFactory {
	public static Emp getEmp() {
		System.out.println("Object is Creating through ObjcetFactory");
		
		Emp emp = new Emp();
		emp.setId(101);
		emp.setName("Sachin");
		emp.setCity("Kolhapur");
		return emp;
	}
}
