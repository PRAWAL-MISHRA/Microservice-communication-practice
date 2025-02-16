package com.pepsico.microservices.employeeService.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	            name = "UUID",
	            strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name="employeeId", length=100, nullable=false, unique=true)
	public String employeeId;
	
	@Column(name="name", length=50, nullable=false, unique=false)
	public String name;
	
	@Column(name="age", length=2, nullable=false, unique=false)
	public int age;
	
	@Column(name="gender", length=6, nullable=false, unique=false)
	public String gender;
	
	@Column(name="address", length=100, nullable=false, unique=false)
	public String address;
	
	public Employee()
	{
		
	}
	
	public Employee(String employeeId, String name, int age, String gender, String address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
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
}
