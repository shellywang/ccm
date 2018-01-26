package cn.edu.saif.ccm.domain.stock;

import java.io.Serializable;
import java.sql.Date;

public class ThreeFactorPK implements Serializable{

	private static final long serialVersionUID = 8687085968944672021L;

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
	
	public boolean equals(Object obj){
		if(obj instanceof ThreeFactorPK){
			ThreeFactorPK other=(ThreeFactorPK)obj;
			if(this.startDate.equals(other.startDate)&&this.dateType==other.dateType){
				return true;
			}
		}
		return false;
	}
}
