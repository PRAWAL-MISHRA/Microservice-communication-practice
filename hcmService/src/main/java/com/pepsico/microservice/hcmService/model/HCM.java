package com.pepsico.microservice.hcmService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class HCM 
{
	@Id
	@Column(name="employeeId", length=100, nullable=false, unique=true)
    public String employeeId;
	
	@Column(name="experince", length=2, nullable=false, unique=false)
    public int experince;
	
	@Column(name="yearsInCurrentRole", length=2, nullable=false, unique=false)
    public int yearsInCurrentRole;
	
	@Column(name="goalCompletedForCurrentYear", length=3, nullable=false, unique=false)
    public String goalCompletedForCurrentYear;
	
	public HCM()
	{
		
	}

	public HCM(String employeeId, int experince, int yearsInCurrentRole, String goalCompletedForCurrentYear) {
		super();
		this.employeeId = employeeId;
		this.experince = experince;
		this.yearsInCurrentRole = yearsInCurrentRole;
		this.goalCompletedForCurrentYear = goalCompletedForCurrentYear;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getExperince() {
		return experince;
	}

	public void setExperince(int experince) {
		this.experince = experince;
	}

	public int getYearsInCurrentRole() {
		return yearsInCurrentRole;
	}

	public void setYearsInCurrentRole(int yearsInCurrentRole) {
		this.yearsInCurrentRole = yearsInCurrentRole;
	}

	public String isGoalCompletedForCurrentYear() {
		return goalCompletedForCurrentYear;
	}

	public void setGoalCompletedForCurrentYear(String goalCompletedForCurrentYear) {
		this.goalCompletedForCurrentYear = goalCompletedForCurrentYear;
	}
}
