package com.h3b.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h3b.investment.model.Bank;

public interface BankRepository extends JpaRepository<Bank, String> {

}
