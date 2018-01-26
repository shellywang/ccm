package cn.edu.saif.ccm.domain.bond;

import java.io.Serializable;
import java.sql.Date;

public class CLBondYieldPK implements Serializable{

	private static final long serialVersionUID = -2667210649377772403L;

	private int dateType;
	
	private Date startDate;

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
		if(obj instanceof CLBondYieldPK){
			CLBondYieldPK other=(CLBondYieldPK)obj;
			if(this.startDate.equals(other.startDate)&&this.dateType==other.dateType){
				return true;
			}
		}
		return false;
	}
}
