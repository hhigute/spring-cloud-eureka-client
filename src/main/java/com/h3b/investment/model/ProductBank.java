package com.h3b.investment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

@Entity
public class ProductBank {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CodeBank", nullable = false)
	@NotEmpty(message = "CodeBank {javax.validation.constraints.NotEmpty.message}")
	@Length(max = 3, message = "CodeBank {javax.validation.constraints.Length.message}")
	private String codeBank;

	@Column(name = "Description", nullable = false)
	@NotEmpty(message = "Description {javax.validation.constraints.NotEmpty.message}")
	@Length(max = 100, message = "Description {javax.validation.constraints.Length.message}")
	private String description;

	@Column(name = "AdministrationFee", nullable = false)
	@DecimalMin(value = "0.0", inclusive = true, message = "AdministrationFee {javax.validation.constraints.DecimalMin.message}")
	@DecimalMax(value = "99.99", inclusive = true, message = "AdministrationFee {javax.validation.constraints.DecimalMax.message}")
	private double administrationFee;

	@Column(name = "DueDate", nullable = true)
	private Date dueDate;

	@Column(name = "LiquidityDay", nullable = false)
	@PositiveOrZero(message = "LiquidityDay {javax.validation.constraints.PositiveOrZero.message}")
	private int liquidityDay;

	@Column(name = "Enabled")
	private boolean enabled;

	@Column(name = "IdRiskLevel", nullable = false)
	private int idRiskLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("IdRiskLevel")
	@JoinColumn(name = "IdRiskLevel")
	private RiskLevel riskLevel;

	public ProductBank() {

	}

	public ProductBank(int id,
			@NotEmpty(message = "CodeBank {javax.validation.constraints.NotEmpty.message}") @Length(max = 3, message = "CodeBank {javax.validation.constraints.Length.message}") String codeBank,
			@NotEmpty(message = "Description {javax.validation.constraints.NotEmpty.message}") @Length(max = 100, message = "Description {javax.validation.constraints.Length.message}") String description,
			@DecimalMin(value = "0.0", inclusive = true, message = "AdministrationFee {javax.validation.constraints.DecimalMin.message}") @DecimalMax(value = "99.99", inclusive = true, message = "AdministrationFee {javax.validation.constraints.DecimalMax.message}") double administrationFee,
			Date dueDate,
			@PositiveOrZero(message = "LiquidityDay {javax.validation.constraints.PositiveOrZero.message}") int liquidityDay,
			boolean enabled, int idRiskLevel, RiskLevel riskLevel) {
		this.id = id;
		this.codeBank = codeBank;
		this.description = description;
		this.administrationFee = administrationFee;
		this.dueDate = dueDate;
		this.liquidityDay = liquidityDay;
		this.enabled = enabled;
		this.idRiskLevel = idRiskLevel;
		this.riskLevel = riskLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeBank() {
		return codeBank;
	}

	public void setCodeBank(String codeBank) {
		this.codeBank = codeBank;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAdministrationFee() {
		return administrationFee;
	}

	public void setAdministrationFee(double administrationFee) {
		this.administrationFee = administrationFee;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getLiquidityDay() {
		return liquidityDay;
	}

	public void setLiquidityDay(int liquidityDay) {
		this.liquidityDay = liquidityDay;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getIdRiskLevel() {
		return idRiskLevel;
	}

	public void setIdRiskLevel(int idRiskLevel) {
		this.idRiskLevel = idRiskLevel;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(administrationFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((codeBank == null) ? 0 : codeBank.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + id;
		result = prime * result + idRiskLevel;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + liquidityDay;
		result = prime * result + ((riskLevel == null) ? 0 : riskLevel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBank other = (ProductBank) obj;
		if (Double.doubleToLongBits(administrationFee) != Double.doubleToLongBits(other.administrationFee))
			return false;
		if (codeBank == null) {
			if (other.codeBank != null)
				return false;
		} else if (!codeBank.equals(other.codeBank))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (idRiskLevel != other.idRiskLevel)
			return false;
		if (enabled != other.enabled)
			return false;
		if (liquidityDay != other.liquidityDay)
			return false;
		if (riskLevel == null) {
			if (other.riskLevel != null)
				return false;
		} else if (!riskLevel.equals(other.riskLevel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductBank [id=" + id + ", codeBank=" + codeBank + ", description=" + description
				+ ", administrationFee=" + administrationFee + ", dueDate=" + dueDate + ", liquidityDay=" + liquidityDay
				+ ", enabled=" + enabled + ", idRiskLevel=" + idRiskLevel + ", riskLevel=" + riskLevel + "]";
	}

}
