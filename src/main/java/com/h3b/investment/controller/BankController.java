package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Bank;
import com.h3b.investment.repository.BankRepository;

@RestController
@RequestMapping(value = "/v1/investment", produces = {"application/json"})
public class BankController {

	@Autowired
	BankRepository bankRepository;
	
	@GetMapping("/bank")
	public List<Bank> listBanks(){
		return bankRepository.findAll();
	}
	
	@GetMapping("/bank/{code}")
	public ResponseEntity<Bank> getBankByCode(@PathVariable("code") String code) throws ResourceNotFoundException{
		Bank bankResponse = bankRepository.findById(code)
											.orElseThrow(
												()-> new ResourceNotFoundException("Bank not found for code: "+code));
		return ResponseEntity.ok().body(bankResponse);
	}
	
	
	@PostMapping("/bank")
	public Bank createBank(@Valid @RequestBody Bank bank){
		return bankRepository.save(bank);
	}
	
}
