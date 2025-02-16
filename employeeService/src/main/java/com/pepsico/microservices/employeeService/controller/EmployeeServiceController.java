package com.pepsico.microservices.employeeService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pepsico.microservices.employeeService.model.EmployeeResponse;
import com.pepsico.microservices.employeeService.model.Employee;
import com.pepsico.microservices.employeeService.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class EmployeeServiceController 
{
	
	public EmployeeService service;
	
	public EmployeeServiceController(EmployeeService service) {
        this.service = service;
    }
	
	@PostMapping("/createEmployee")
	@Retry(name = "default", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployeeWithPromotionEligibleStatus/{employeeId}")
	@Retry(name = "default", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public ResponseEntity<EmployeeResponse> getStatus(@PathVariable String employeeId) {
        EmployeeResponse response = service.getEmployeeWithPromotionEligibleStatus(employeeId);
        if(response != null)
        	return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
	
	public String hardcodedResponse(Exception ex)
    {
    	return "fallback-response";
    }
}
