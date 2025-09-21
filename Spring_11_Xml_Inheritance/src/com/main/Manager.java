package com.main;

public class Manager {
	private int id;
	private String name;
	private String companyName;
	private String companyUId;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public Manager(int id, String name, String companyName, String companyUId) {
		super();
		this.id = id;
		this.name = name;
		this.companyName = companyName;
		this.companyUId = companyUId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyUId() {
		return companyUId;
	}
	public void setCompanyUId(String companyUId) {
		this.companyUId = companyUId;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", companyName=" + companyName + ", companyUId=" + companyUId
				+ "]";
	}
}
