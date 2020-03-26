package com.h3b.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.h3b.investment.model.RiskLevel;

public interface RiskLevelRepository extends JpaRepository<RiskLevel, Integer> {
	
	@Query(value = "select * from RiskLevel where Description like %?1%", nativeQuery = true)
	RiskLevel findRiskLevelByDescription(String description);

}
