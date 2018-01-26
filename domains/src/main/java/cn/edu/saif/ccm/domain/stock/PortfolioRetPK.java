package cn.edu.saif.ccm.domain.stock;

import java.io.Serializable;
import java.util.Date;

public class PortfolioRetPK implements Serializable{

	private static final long serialVersionUID = -1004746492077256926L;

	private int dateType;
	
	private Date startDate;
	
	private int ranking;

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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof PortfolioRetPK){
			PortfolioRetPK other=(PortfolioRetPK)obj;
			if(this.startDate.equals(other.startDate)&&this.dateType==other.dateType
					&&this.ranking==other.ranking){
				return true;
			}
		}
		return false;
	}
}
