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
@Table(name = "CCM_GBOND_MATURITY")
@JsonInclude(Include.NON_NULL)
@IdClass(GBondMatPK.class)
public class GBondMat implements Serializable{

	private static final long serialVersionUID = 2740053326340596304L;

	@Id
	@Column(name = "BONDCODE", nullable = false)
	private String bondCode;
	
	@Id
	@Column(name = "DATETYPE", nullable = false)
	private int dateType;

	@Id
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;
	
	
	@Column(name = "ENDDATE")
	private Date endDate;
	
	@Column(name = "MATURITY", nullable = false)
	private String maturity;
	
	@Column(name = "TYPE", nullable = false)
	private String type;

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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
