package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.RiskLevel;
import com.h3b.investment.repository.RiskLevelRepository;

@RestController
@RequestMapping(value = "/v1/investment", produces = {"application/json"})
public class RiskLevelController {

	@Autowired
	RiskLevelRepository riskLevelRepository;
	
	@GetMapping("/riskLevel")
	public List<RiskLevel> listRiskLevels(){
		return riskLevelRepository.findAll();
	}
	
	@GetMapping("/riskLevel/{description}")
	public ResponseEntity<RiskLevel> findRiskLevelByDescription(@Valid @PathVariable("description") String description)
															throws ResourceNotFoundException{
		RiskLevel riskLevel = riskLevelRepository.findRiskLevelByDescription(description);
		
		if(riskLevel == null)
			throw new ResourceNotFoundException("RiskLevel not found for description: "+description);	
		
		return ResponseEntity.ok().body(riskLevel);
	}
	
}
