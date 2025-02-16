package com.pepsico.microservices.employeeService.model;

public class HCM 
{
	public String employeeId;
	public int experince;
	public int yearsInCurrentRole;
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
