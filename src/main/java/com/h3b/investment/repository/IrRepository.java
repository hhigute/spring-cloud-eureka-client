package com.h3b.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.h3b.investment.model.Ir;

public interface IrRepository extends JpaRepository<Ir, Integer> {
	
	Ir findByRangeDay(@Param("day") int day);

}
