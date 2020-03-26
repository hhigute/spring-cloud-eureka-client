package com.h3b.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h3b.investment.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
