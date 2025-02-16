package com.pepsico.microservices.employeeService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pepsico.microservices.employeeService.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> 
{
	
}