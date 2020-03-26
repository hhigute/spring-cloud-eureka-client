package com.h3b.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h3b.investment.model.CustomerBank;
import com.h3b.investment.model.constraint.CustomerBankPrimaryKey;

public interface CustomerBankRepository extends JpaRepository<CustomerBank, CustomerBankPrimaryKey> {

}
