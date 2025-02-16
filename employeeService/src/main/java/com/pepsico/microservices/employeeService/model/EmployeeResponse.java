package com.pepsico.microservices.employeeService.model;

public class EmployeeResponse 
{
	public String employeeId;
	public String name;
	public int age;
	public String gender;
	public String address;
	public Character isEligible;
	
	public EmployeeResponse()
	{
		
	}
	
	public EmployeeResponse(String employeeId, String name, int age, String gender, String address,
			Character isEligible) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.isEligible = isEligible;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Character getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(Character isEligible) {
		this.isEligible = isEligible;
	}
}
