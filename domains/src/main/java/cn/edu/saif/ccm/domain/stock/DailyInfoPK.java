package cn.edu.saif.ccm.domain.stock;

import java.io.Serializable;
import java.util.Date;

public class DailyInfoPK implements Serializable{
	
	private static final long serialVersionUID = -1204655691082553946L;

	public String stockCode;
	
	public Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof DailyInfoPK){
			DailyInfoPK other=(DailyInfoPK)obj;
			if(this.date.equals(other.date)&&this.stockCode.equals(other.stockCode)){
				return true;
			}
		}
		return false;
	}
}
