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
@Table(name = "CCM_THREEFACTOR")
@JsonInclude(Include.NON_NULL)
@IdClass(ThreeFactorPK.class)
public class ThreeFactor implements Serializable{

	private static final long serialVersionUID = -3949682752804117702L;

	@Id
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;
	
	@Id
	@Column(name = "DATETYPE", nullable = false)
	private int dateType;
	
	@Column(name = "ENDDATE")
	private Date endDate;
	
	@Column(name = "RMF", nullable = false )
	private String rmf;
	
	@Column(name = "SMB", nullable = false )
	private String smb;
	
	@Column(name = "HML", nullable = false )
	private String hml;
	
	@Column(name = "RF", nullable = false )
	private String rf;

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

	public String getRmf() {
		return rmf;
	}

	public void setRmf(String rmf) {
		this.rmf = rmf;
	}

	public String getSmb() {
		return smb;
	}

	public void setSmb(String smb) {
		this.smb = smb;
	}

	public String getHml() {
		return hml;
	}

	public void setHml(String hml) {
		this.hml = hml;
	}

	public String getRf() {
		return rf;
	}

	public void setRf(String rf) {
		this.rf = rf;
	}
	
}
