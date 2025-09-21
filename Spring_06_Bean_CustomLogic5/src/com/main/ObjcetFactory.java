package com.main;

public class ObjcetFactory {
	Address addr;
	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public Emp getEmp() {
		System.out.println("Object is Creating through ObjcetFactory + Dependency");
		
		Emp emp = new Emp();
		emp.setId(101);
		emp.setName("Sachin");
		emp.setCity("Kolhapur");
		emp.setAddress(addr);
		return emp;
	}
}
