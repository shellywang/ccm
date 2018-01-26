package cn.edu.saif.ccm.domain.stock;

import java.io.Serializable;
import java.util.Date;

public class StockRetPK implements Serializable{

	private static final long serialVersionUID = 7545154870427236230L;

	private String stockCode;
	
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

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof StockRetPK){
			StockRetPK other=(StockRetPK)obj;
			if(this.startDate.equals(other.startDate)&&this.dateType==other.dateType
					&&this.stockCode.equals(other.stockCode)){
				return true;
			}
		}
		return false;
	}
	
}
