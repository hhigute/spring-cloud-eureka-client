package com.h3b.investment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Iof;
import com.h3b.investment.repository.IofRepository;

@RestController
@RequestMapping(value = "/v1/investment", produces = {"application/json"})
public class IofController{

	@Autowired
	private IofRepository iofRepository;
	
	@GetMapping("/iof")
	public List<Iof> listIofs(){
		return iofRepository.findAll();
	}

	@GetMapping("/iof/{nrDay}")
	public ResponseEntity<Iof> getIofByNrDay(@PathVariable(value="nrDay") int nrDay) throws ResourceNotFoundException {
		Iof iof = iofRepository.findById(nrDay)
				.orElseThrow(
						()-> new ResourceNotFoundException ("Iof not found for this day: "+nrDay)
				);
		return ResponseEntity.ok().body(iof);
	}
}