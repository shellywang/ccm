package cn.edu.saif.ccm.domain.bond;

import java.io.Serializable;
import java.util.Date;

public class GBondRetPK implements Serializable{

	private static final long serialVersionUID = -2472740333758828152L;

	private String bondCode;
	
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

	public String getBondCode() {
		return bondCode;
	}

	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof GBondRetPK){
			GBondRetPK other=(GBondRetPK)obj;
			if(this.startDate.equals(other.startDate)&&this.dateType==other.dateType
					&&this.bondCode.equals(other.bondCode)){
				return true;
			}
		}
		return false;
	}
}
