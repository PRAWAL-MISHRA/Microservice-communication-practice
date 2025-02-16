package com.pepsico.microservices.employeeService.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pepsico.microservices.employeeService.model.HCM;

@FeignClient(value = "hcm", url = "http://localhost:8100")
public interface HCMClient 
{

    @GetMapping("/hcm/readHCM/{employeeId}")
    ResponseEntity<HCM> readHCM(@PathVariable String employeeId);

    @GetMapping("/hcm/isEligible/{employeeId}")
    ResponseEntity<Character> isEligible(@PathVariable String employeeId);
}
