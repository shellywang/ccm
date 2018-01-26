package cn.edu.saif.ccm.domain.bond;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "CCM_GBOND_PRICE")
@JsonInclude(Include.NON_NULL)
@IdClass(GBondPrcPK.class)
public class GBondPrc implements Serializable{
	
	private static final long serialVersionUID = 8750561801861987514L;

	@Id
	@Column(name = "BONDCODE", nullable = false)
	private String bondCode;
	
	@Id
	@Column(name = "TRADEDATE", nullable = false)
	private Date tradeDate;
	
	@Column(name = "CLOSEPRICE", nullable = false)
	private String closePrc;
	
	@Column(name = "VOL", nullable = false)
	private int vol;
	
	@Column(name = "ACCI")
	private String acci;
	
	@Column(name = "ACCD", nullable = false)
	private int accd;
	
	@Column(name = "PTMYEAR", nullable = false)
	private String ptmYear;
	
	@Column(name = "YTM", nullable = false)
	private String ytm;
	
	@Column(name = "TYPE", nullable = false)
	private String type;

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

	public String getClosePrc() {
		return closePrc;
	}

	public void setClosePrc(String closePrc) {
		this.closePrc = closePrc;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getAcci() {
		return acci;
	}

	public void setAcci(String acci) {
		this.acci = acci;
	}

	public int getAccd() {
		return accd;
	}

	public void setAccd(int accd) {
		this.accd = accd;
	}

	public String getPtmYear() {
		return ptmYear;
	}

	public void setPtmYear(String ptmYear) {
		this.ptmYear = ptmYear;
	}

	public String getYtm() {
		return ytm;
	}

	public void setYtm(String ytm) {
		this.ytm = ytm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
