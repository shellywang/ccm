package cn.edu.saif.ccm.domain.stock;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "CCM_STOCK_RET")
@JsonInclude(Include.NON_NULL)
@IdClass(StockRetPK.class)
public class StockRet implements Serializable{

	private static final long serialVersionUID = -4937851934807254012L;

	@Id
	@Column(name = "STOCKCODE", nullable = false)
	private String stockCode;
	
	@Id
	@Column(name = "DATETYPE", nullable = false)
	private int dateType;
	
	@Id
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;
	
	@Column(name = "ENDDATE")
	private Date endDate;
	
	@Column(name = "RET")
	private String ret;
	
	@Column(name = "RET_CAPAPP")
	private String capAppRet;
	
	@Column(name = "RET_INCOME")
	private String incomeRet;

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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRet() {
		if(ret.equals("0E-9"))
			return "0";
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getCapAppRet() {
		if(capAppRet.equals("0E-9"))
			return "0";
		return capAppRet;
	}

	public void setCapAppRet(String capAppRet) {
		this.capAppRet = capAppRet;
	}

	public String getIncomeRet() {
		if(incomeRet.equals("0E-9"))
			return "0";
		return incomeRet;
	}

	public void setIncomeRet(String incomeRet) {
		this.incomeRet = incomeRet;
	}
	
}
