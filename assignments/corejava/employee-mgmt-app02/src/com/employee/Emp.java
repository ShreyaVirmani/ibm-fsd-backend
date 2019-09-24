package com.employee;
public class Emp
{
	
	int id;
	String name;
	String designation;
	String company;
	
	
	
	
	public Emp() {
		super();
	}
	public Emp(int id, String name, String designation, String company) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.company = company;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	
	
	
	
}

