package com.h3b.investment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IofRference")
public class Iof {

	@Id
	@Column(name = "NrDay", nullable = false)
	private int nrDay;

	@Column(name = "PercentFee", nullable = false)
	private double percentFee;

	public Iof() {

	}

	public Iof(int nrDay, double percentFee) {
		this.nrDay = nrDay;
		this.percentFee = percentFee;
	}

	public int getNrDay() {
		return nrDay;
	}

	public void setNrDay(int nrDay) {
		this.nrDay = nrDay;
	}

	public double getPercentFee() {
		return percentFee;
	}

	public void setPercentFee(double percentFee) {
		this.percentFee = percentFee;
	}

	@Override
	public String toString() {
		return "Iof [nrDay=" + nrDay + ", percentFee=" + percentFee + "]";
	}

}
