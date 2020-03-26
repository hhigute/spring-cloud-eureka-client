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
import com.h3b.investment.model.Ir;
import com.h3b.investment.repository.IrRepository;

@RestController
@RequestMapping(value = "/v1/investment", produces = {"application/json"})
public class IrController {
	
	@Autowired
	IrRepository irRepository;
	
	
	@GetMapping("/ir")
	public List<Ir> listIrs(){
		return irRepository.findAll();
	}
	
	
	@GetMapping("/ir/{day}")
	public ResponseEntity<Ir> findByRangeDay(@Valid @PathVariable(value="day") int day) throws ResourceNotFoundException {
		
		Ir ir = irRepository.findByRangeDay(day);
		
		if(ir == null)
			throw new ResourceNotFoundException("IR not found for this day: "+day);
		
		return ResponseEntity.ok().body(ir);
		
	}
	
	
}
