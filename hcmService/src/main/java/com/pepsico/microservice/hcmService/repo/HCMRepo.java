package com.pepsico.microservice.hcmService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pepsico.microservice.hcmService.model.HCM;

@Repository
public interface HCMRepo extends JpaRepository<HCM, String> 
{
}
