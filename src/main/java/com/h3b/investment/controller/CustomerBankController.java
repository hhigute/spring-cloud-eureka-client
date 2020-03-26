package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.model.CustomerBank;
import com.h3b.investment.repository.CustomerBankRepository;



@RestController
@RequestMapping(value="/v1/investment" , produces = {"application/json"})
public class CustomerBankController {

	
	@Autowired
	CustomerBankRepository customerBankRepository; 
	
	
	@GetMapping("/customerBank")
	public List<CustomerBank> listCustomerBank(){
		return customerBankRepository.findAll();
	}
	
	@PostMapping("/customerBank")
	public CustomerBank createCustomerBank(@Valid @RequestBody CustomerBank customerBank) throws Exception{
	
		return customerBankRepository.save(customerBank);
		
	}
	
}
