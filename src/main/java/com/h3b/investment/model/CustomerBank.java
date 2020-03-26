package com.h3b.investment.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.h3b.investment.model.constraint.CustomerBankPrimaryKey;

@Entity
@IdClass(CustomerBankPrimaryKey.class)
public class CustomerBank {

	@Id
	@Column(name = "CustomerDoc", nullable = false)
	@NotBlank(message = "CustomerDoc {javax.validation.constraints.NotBlank.message}")
	@Length(max = 19, message = "CustomerDoc {javax.validation.constraints.Length.messsage}")
	private String customerDoc;

	@Id
	@Column(name = "CodeBank", nullable = false)
	@NotBlank(message = "CodeBank {javax.validation.constraints.NotBlank.message}")
	@Length(max = 3, message = "CodeBank {javax.validation.constraints.Length.messsage}")
	private String codeBank;

	@Column(name = "BranchCode", nullable = false)
	@NotBlank(message = "BranchCode {javax.validation.constraints.NotBlank.message}")
	@Length(max = 5, message = "BranchCode {javax.validation.constraints.Length.messsage}")
	private String branchCode;

	@Column(name = "AccountNumber", nullable = false)
	@NotBlank(message = "AccountNumber {javax.validation.constraints.NotBlank.message}")
	@Length(max = 15, message = "AccountNumber {javax.validation.constraints.Length.messsage}")
	private String accountNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("CustomerDoc")
	@JoinColumn(name = "CustomerDoc")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("CodeBank")
	@JoinColumn(name = "CodeBank")
	private Bank bank;

	public CustomerBank() {

	}

	public CustomerBank(
			@NotBlank(message = "CustomerDoc {javax.validation.constraints.NotBlank.message}") @Length(max = 19, message = "CustomerDoc {javax.validation.constraints.Length.messsage}") String customerDoc,
			@NotBlank(message = "CodeBank {javax.validation.constraints.NotBlank.message}") @Length(max = 3, message = "CodeBank {javax.validation.constraints.Length.messsage}") String codeBank,
			@NotBlank(message = "BranchCode {javax.validation.constraints.NotBlank.message}") @Length(max = 5, message = "BranchCode {javax.validation.constraints.Length.messsage}") String branchCode,
			@NotBlank(message = "AccountNumber {javax.validation.constraints.NotBlank.message}") @Length(max = 15, message = "AccountNumber {javax.validation.constraints.Length.messsage}") String accountNumber,
			Customer customer, Bank bank) {
		this.customerDoc = customerDoc;
		this.codeBank = codeBank;
		this.branchCode = branchCode;
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.bank = bank;
	}

	public String getCustomerDoc() {
		return customerDoc;
	}

	public void setCustomerDoc(String customerDoc) {
		this.customerDoc = customerDoc;
	}

	public String getCodeBank() {
		return codeBank;
	}

	public void setCodeBank(String codeBank) {
		this.codeBank = codeBank;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
		result = prime * result + ((codeBank == null) ? 0 : codeBank.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((customerDoc == null) ? 0 : customerDoc.hashCode());
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
		CustomerBank other = (CustomerBank) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (branchCode == null) {
			if (other.branchCode != null)
				return false;
		} else if (!branchCode.equals(other.branchCode))
			return false;
		if (codeBank == null) {
			if (other.codeBank != null)
				return false;
		} else if (!codeBank.equals(other.codeBank))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerDoc == null) {
			if (other.customerDoc != null)
				return false;
		} else if (!customerDoc.equals(other.customerDoc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerBank [customer=" + customer + ", bank=" + bank + ", customerDoc=" + customerDoc + ", codeBank="
				+ codeBank + ", branchCode=" + branchCode + ", accountNumber=" + accountNumber + "]";
	}

}
