package com.h3b.investment.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity(name = "Customer")
public class Customer {

	@Id
	@Column(name = "Document", nullable = false)
	@NotBlank(message = "Document {javax.validation.constraints.NotBlank.message}")
	@Length(max = 19, message = "Document {javax.validation.constraints.Length.message}")
	private String document;

	@Column(name = "Name", nullable = false)
	@Length(max = 50, message = "Name {javax.validation.constraints.Length.message}")
	@NotBlank(message = "Name {javax.validation.constraints.NotBlank.message}")
	private String name;

	@Column(name = "Phone", nullable = false)
	@Length(max = 15, message = "Phone {javax.validation.constraints.Length.message}")
	@NotBlank(message = "Phone {javax.validation.constraints.NotBlank.message}")
	private String phone;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "CustomerBank",
            joinColumns = {@JoinColumn(name = "CustomerDoc")},
            inverseJoinColumns = {@JoinColumn(name = "CodeBank")}
    )
    private Set<Bank> banks = new HashSet<>();

	public Set<Bank> getBanks() {
        return banks;
    }
	
	public Customer() {

	}

	public Customer(
			@NotBlank(message = "Document {javax.validation.constraints.NotBlank.message}") @Length(max = 19, message = "Document {javax.validation.constraints.Length.message}") String document,
			@Length(max = 50, message = "Name {javax.validation.constraints.Length.message}") @NotBlank(message = "Name {javax.validation.constraints.NotBlank.message}") String name,
			@Length(max = 15, message = "Phone {javax.validation.constraints.Length.message}") @NotBlank(message = "Phone {javax.validation.constraints.NotBlank.message}") String phone,
			Set<Bank> banks) {
		this.document = document;
		this.name = name;
		this.phone = phone;
		this.banks = banks;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banks == null) ? 0 : banks.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Customer other = (Customer) obj;
		if (banks == null) {
			if (other.banks != null)
				return false;
		} else if (!banks.equals(other.banks))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [document=" + document + ", name=" + name + ", phone=" + phone + ", customerBank="
				+ banks + "]";
	}

}
