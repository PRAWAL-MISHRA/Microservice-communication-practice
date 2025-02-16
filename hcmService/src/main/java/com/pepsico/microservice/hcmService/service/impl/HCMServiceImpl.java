package com.pepsico.microservice.hcmService.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepsico.microservice.hcmService.model.HCM;
import com.pepsico.microservice.hcmService.repo.HCMRepo;
import com.pepsico.microservice.hcmService.service.HCMService;

@Service
public class HCMServiceImpl implements HCMService {

    @Autowired
    HCMRepo hcmRepo;

    @Override
    public void createHCM(String employeeId, HCM hcm) {
        if(hcmRepo.findById(employeeId).isPresent()) 
        {
        	List<HCM> hcmlist = hcmRepo.findAll();
            hcmlist.removeIf(q -> q.getEmployeeId().equals(employeeId));
            hcmlist.add(hcm);
            hcmRepo.saveAll(hcmlist);
            return;
        }
        hcmRepo.save(hcm);
    }

    @Override
    public HCM readHCM(String employeeId) {
        return hcmRepo.findById(employeeId).get();
    }

    @Override
    public Character isEligible(String employeeId) {
        Optional<HCM> response = hcmRepo.findById(employeeId);
        if(response.isPresent()) {
            HCM obj = response.get();
            return obj.getYearsInCurrentRole() >= 3 && obj.isGoalCompletedForCurrentYear().equalsIgnoreCase("yes") ? 'Y' : 'N';
        }
        return null;
    }
}
