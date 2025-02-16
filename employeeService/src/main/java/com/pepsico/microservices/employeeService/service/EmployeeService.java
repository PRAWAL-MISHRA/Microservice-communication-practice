package com.pepsico.microservices.employeeService.service;

import org.springframework.stereotype.Service;

import com.pepsico.microservices.employeeService.model.Employee;
import com.pepsico.microservices.employeeService.model.EmployeeResponse;

@Service
public interface EmployeeService {

    public String createEmployee(Employee employee);
    
    public EmployeeResponse getEmployeeWithPromotionEligibleStatus(String employeeId);

}
