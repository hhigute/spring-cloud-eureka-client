package com.h3b.investment.model.constraint;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class IrPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "StartDay")
	private int startDay;
	@Column(name = "FinishDay")
	private int finishDay;

	public IrPrimaryKey() {

	}

	public IrPrimaryKey(int startDay, int finishDay) {
		this.startDay = startDay;
		this.finishDay = finishDay;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finishDay;
		result = prime * result + startDay;
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
		IrPrimaryKey other = (IrPrimaryKey) obj;
		if (finishDay != other.finishDay)
			return false;
		if (startDay != other.startDay)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IrPrimaryKey [startDay=" + startDay + ", finishDay=" + finishDay + "]";
	}
	
	

}
