package cn.edu.saif.ccm.domain.bond;

import java.io.Serializable;
import java.sql.Date;

public class CLBondCapAppRetPK implements Serializable{

	private static final long serialVersionUID = -52951306066403621L;

	private Date startDate;
	
	private int dateType;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDateType() {
		return dateType;
	}

	public void setDateType(int dateType) {
		this.dateType = dateType;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof CLBondCapAppRetPK){
			CLBondCapAppRetPK other=(CLBondCapAppRetPK)obj;
			if(this.startDate.equals(other.startDate)&&this.dateType==other.dateType){
				return true;
			}
		}
		return false;
	}
}
