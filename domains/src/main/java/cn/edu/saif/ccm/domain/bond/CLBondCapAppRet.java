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
@Table(name = "CCM_CLBOND_CAPAPP_RET")
@JsonInclude(Include.NON_NULL)
@IdClass(CLBondCapAppRetPK.class)
public class CLBondCapAppRet implements Serializable{

	private static final long serialVersionUID = 5951483397814685736L;

	@Id
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;
	
	@Id
	@Column(name = "DATETYPE", nullable = false)
	private int dateType;
	
	@Column(name = "ENDDATE")
	private Date endDate;
	
	@Column(name = "RET", nullable = false)
	private String ret;

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
}
