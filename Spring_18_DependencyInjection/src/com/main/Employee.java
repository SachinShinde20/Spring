package com.main;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class Employee {
	private int id;
//	@Autowired *3
	private Address addr;
//	@Autowired *3
//	@Qualifier("getTestMarks")
	private Map<String, Integer> marks;

	public Employee() {
		System.out.println("\nDefault Construtor Called... (1)");
	}

//	@Autowired *2
//	public Employee(Address addr, @Qualifier("getTestMarks") Map<String, Integer> marks) // for multiple dependancy found
	public Employee(Address addr, Map<String, Integer> marks) {
		super();
		this.addr = addr;
		this.marks = marks;
		System.out.println("\nSetting addr, marks via Constructor (2)");
	}

	// This will not work -> because it contains int (primitive) require all
	// reference type
	public Employee(int id, Address addr, Map<String, Integer> marks) {
		super();
		this.id = id;
		this.addr = addr;
		this.marks = marks;
		System.out.println("\nSetting id, addr, marks via Constructor (3)");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("Setting id");
	}

	public Address getAddr() {
		return addr;
	}

	@Autowired // *1
	public void setAddr(Address addr) {
		this.addr = addr;
		System.out.println("Setting Address");
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}

	@Autowired // *1
	@Qualifier("getTestMarks")
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
		System.out.println("Setting Marks");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", addr=" + addr + ", marks=" + marks + "]";
	}
}
