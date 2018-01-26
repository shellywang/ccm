package cn.edu.saif.ccm.domain.bond;

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
@Table(name = "CCM_CLBOND_YIELD")
@JsonInclude(Include.NON_NULL)
@IdClass(CLBondYieldPK.class)
public class CLBondYield implements Serializable{

	private static final long serialVersionUID = -6546200212101308076L;

	@Id
	@Column(name = "DATETYPE", nullable = false)
	private int dateType;
	
	@Id
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;
	
	@Column(name = "ENDDATE")
	private Date endDate;
	
	@Column(name = "YTM", nullable = false)
	private String ytm;

	public int getDateType() {
		return dateType;
	}

	public void setDateType(int dateType) {
		this.dateType = dateType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getYtm() {
		return ytm;
	}

	public void setYtm(String ytm) {
		this.ytm = ytm;
	}
	
}
