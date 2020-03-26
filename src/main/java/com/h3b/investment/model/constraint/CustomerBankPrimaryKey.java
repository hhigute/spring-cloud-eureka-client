package com.h3b.investment.model.constraint;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class CustomerBankPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "CustomerDoc")
	private String customerDoc;
	@Column(name = "CodeBank")
	private String codeBank;

	public CustomerBankPrimaryKey() {

	}

	public CustomerBankPrimaryKey(String customerDoc, String codeBank) {
		this.customerDoc = customerDoc;
		this.codeBank = codeBank;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeBank == null) ? 0 : codeBank.hashCode());
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
		CustomerBankPrimaryKey other = (CustomerBankPrimaryKey) obj;
		if (codeBank == null) {
			if (other.codeBank != null)
				return false;
		} else if (!codeBank.equals(other.codeBank))
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
		return "CustomerBankPrimaryKey [customerDoc=" + customerDoc + ", codeBank=" + codeBank + "]";
	}
	
	

}
