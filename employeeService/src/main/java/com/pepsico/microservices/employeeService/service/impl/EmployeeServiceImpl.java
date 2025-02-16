package com.pepsico.microservices.employeeService.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pepsico.microservices.employeeService.model.HCM;
import com.pepsico.microservices.employeeService.restClient.HCMClient;
import com.pepsico.microservices.employeeService.model.Employee;
import com.pepsico.microservices.employeeService.model.EmployeeResponse;
import com.pepsico.microservices.employeeService.repo.EmployeeRepo;
import com.pepsico.microservices.employeeService.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	public EmployeeRepo repo;
	
	@Autowired
    public HCMClient client;
	
	@Override
    public String createEmployee(Employee employee) {
        return repo.save(employee).getEmployeeId();
    }

	@Override
    public EmployeeResponse getEmployeeWithPromotionEligibleStatus(String employeeId) {
        Optional<Employee> employeeOpt = repo.findById(employeeId);
        if(!employeeOpt.isPresent())
            return null;
        ResponseEntity<HCM> hcm = client.readHCM(employeeId);
        if (hcm.getStatusCode() == HttpStatus.OK) {
            ResponseEntity<Character> eligible = client.isEligible(employeeId);
            if(eligible.getStatusCode() == HttpStatus.OK) {
                Employee employee = employeeOpt.get();
                EmployeeResponse employeeResponse = new EmployeeResponse();
                employeeResponse.setEmployeeId(employeeId);
                employeeResponse.setName(employee.getName());
                employeeResponse.setAge(employee.getAge());
                employeeResponse.setGender(employee.getGender());
                employeeResponse.setAddress(employee.getAddress());
                employeeResponse.setIsEligible(eligible.getBody());
                return employeeResponse;
            }
        }
        return null;
	}
}
