package com.pepsico.microservice.hcmService.service;

import org.springframework.stereotype.Service;

import com.pepsico.microservice.hcmService.model.HCM;

@Service
public interface HCMService {

    public void createHCM(String employeeId, HCM hcm);
    public HCM readHCM(String employeeId);
    public Character isEligible(String employeeId);

}
