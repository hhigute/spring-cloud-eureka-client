package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Customer;
import com.h3b.investment.repository.CustomerRepository;


@RestController
@RequestMapping(value = "/v1/investment", produces = {"application/json"})
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customer" )
	public List<Customer> listCustomer(){
		return customerRepository.findAll();
	}
	
	
	@GetMapping("/customer/{doc}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "doc") String doc) throws ResourceNotFoundException{
		
		Customer customerResponse = customerRepository.findById(doc)
														.orElseThrow(
																()-> new ResourceNotFoundException("Customer not found for document: "+doc)
															
														);
		
		return ResponseEntity.ok().body(customerResponse);
		
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	@PutMapping("/customer/{doc}")
	public ResponseEntity<Customer> updateCustomer(	@PathVariable(name="doc") String doc,
													@Valid @RequestBody Customer customerRequest) 
															throws ResourceNotFoundException{
		
		Customer customer = customerRepository.findById(doc)
												.orElseThrow(
														()-> new ResourceNotFoundException("Customer not found for document: "+doc));
		
		customer.setDocument(customerRequest.getDocument());
		customer.setName(customerRequest.getName());
		customer.setPhone(customerRequest.getPhone());
		
		final Customer customerUpdated = customerRepository.save(customer);
		
		return ResponseEntity.ok().body(customerUpdated);
	}
	
}
