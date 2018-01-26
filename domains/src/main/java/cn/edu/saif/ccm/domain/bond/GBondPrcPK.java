package cn.edu.saif.ccm.domain.bond;

import java.io.Serializable;
import java.sql.Date;

public class GBondPrcPK implements Serializable{

	private static final long serialVersionUID = 7686344217618234563L;
	
	private String bondCode;

	private Date tradeDate;
	
	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getBondCode() {
		return bondCode;
	}

	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof GBondPrcPK){
			GBondPrcPK other=(GBondPrcPK)obj;
			if(this.tradeDate.equals(other.tradeDate) && this.bondCode.equals(other.bondCode)){
				return true;
			}
		}
		return false;
	}
}
