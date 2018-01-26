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
@Table(name = "CCM_PORTFOLIO_SIZE_RET")
@JsonInclude(Include.NON_NULL)
@IdClass(PortfolioRetPK.class)
public class PortfolioRet implements Serializable{

	private static final long serialVersionUID = -7946296770234194167L;

	@Id
	@Column(name = "DATETYPE", nullable = false)
	private int dateType;

	@Id
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;
	
	@Id
	@Column(name = "RANKING", nullable = false)
	private int ranking;
	
	@Column(name = "ENDDATE")
	private Date endDate;
	
	@Column(name = "RET", nullable = false)
	private String ret;

	@Column(name = "RET_CAPAPP", nullable = false)
	private String capAppRet;
	
	@Column(name = "RET_INCOME", nullable = false)
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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getCapAppRet() {
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
