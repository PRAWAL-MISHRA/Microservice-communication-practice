package com.pepsico.microservice.hcmService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pepsico.microservice.hcmService.model.HCM;
import com.pepsico.microservice.hcmService.service.HCMService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;

@RestController
public class HcmServiceController 
{
	public HCMService service;

    public HcmServiceController(HCMService service) {
        this.service = service;
    }

    @PostMapping("/createHCM")
    @Retry(name = "default", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public ResponseEntity<Boolean> createHCM(@RequestBody HCM hcm) 
    {
        service.createHCM(hcm.getEmployeeId(), hcm);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
    
    @GetMapping("/readHCM/{employeeId}")
    @Retry(name = "default", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public ResponseEntity<HCM> readHCM(@Valid @PathVariable String employeeId) {
        HCM hcm = service.readHCM(employeeId);
        if(hcm != null)
        	return new ResponseEntity<>(hcm, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/isEligible/{employeeId}")
    @Retry(name = "default", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public ResponseEntity<Character> isEligible(@Valid @PathVariable String employeeId) {
        Character c = service.isEligible(employeeId);
        if(c != null)
        	return new ResponseEntity<>(c, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    public String hardcodedResponse(Exception ex)
    {
    	return "fallback-response";
    }
}
