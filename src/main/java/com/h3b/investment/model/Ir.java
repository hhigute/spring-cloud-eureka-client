package com.h3b.investment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.h3b.investment.model.constraint.IrPrimaryKey;

@Entity
@Table(name = "IRReference")
@IdClass(IrPrimaryKey.class)
@NamedNativeQuery(name = "Ir.findByRangeDay", query = "SELECT * FROM IRReference i WHERE ? BETWEEN i.StartDay AND i.FinishDay", resultClass = Ir.class)
public class Ir {

	@Id
	@Column(name = "StartDay", nullable = false)
	private int startDay;

	@Id
	@Column(name = "FinishDay", nullable = false)
	private int finishDay;

	@Column(name = "PercentFee", nullable = false)
	private double percentFee;

	public Ir() {

	}

	public Ir(int startDay, int finishDay, double percentFee) {
		this.startDay = startDay;
		this.finishDay = finishDay;
		this.percentFee = percentFee;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getFinishDay() {
		return finishDay;
	}

	public void setFinishDay(int finishDay) {
		this.finishDay = finishDay;
	}

	public double getPercentFee() {
		return percentFee;
	}

	public void setPercentFee(double percentFee) {
		this.percentFee = percentFee;
	}

	@Override
	public String toString() {
		return "Ir [startDay=" + startDay + ", finishDay=" + finishDay + ", percentFee=" + percentFee + "]";
	}
}
