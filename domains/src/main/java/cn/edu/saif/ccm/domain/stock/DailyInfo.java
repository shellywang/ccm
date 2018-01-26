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
@Table(name = "CCM_STOCK_DAILY_INFO")
@JsonInclude(Include.NON_NULL)
@IdClass(DailyInfoPK.class)
public class DailyInfo implements Serializable{

	private static final long serialVersionUID = 7448009379069365090L;

	@Id
	@Column(name = "STOCKCODE", nullable = false)
	private String stockCode;
	
	@Id
	@Column(name = "DATE", nullable = false)
	private Date date;
	
	@Column(name = "HEXCD", nullable = false)
	private String hexCode;
	
	@Column(name = "OPENPRC")
	private String openPrc;
	
	@Column(name = "PRC")
	private String prc;
	
	@Column(name = "VOL")
	private Integer vol;
	
	@Column(name = "FASHR", nullable = false)
	private String fAShr;
	
	@Column(name = "TASHR", nullable = false)
	private String tAShr;
	
	@Column(name = "RET")
	private String ret;
	
	@Column(name = "CFACPR")
	private String cFacPrc;
	
	@Column(name = "CFACSHR")
	private String cFacShr;
	
	@Column(name = "RETX")
	private String retX;
	
	@Column(name = "EXCHTRD")
	private Integer exchTrd;
	
	@Column(name = "STKTRD")
	private Integer stkTrd;

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

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}

	public String getOpenPrc() {
		return openPrc;
	}

	public void setOpenPrc(String openPrc) {
		this.openPrc = openPrc;
	}

	public String getPrc() {
		return prc;
	}

	public void setPrc(String prc) {
		this.prc = prc;
	}

	public Integer getVol() {
		return vol;
	}

	public void setVol(Integer vol) {
		this.vol = vol;
	}

	public String getfAShr() {
		return fAShr;
	}

	public void setfAShr(String fAShr) {
		this.fAShr = fAShr;
	}

	public String gettAShr() {
		return tAShr;
	}

	public void settAShr(String tAShr) {
		this.tAShr = tAShr;
	}

	public String getRet() {
		if("0.00000".equals(ret))
			return "0";
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getcFacPrc() {
		return cFacPrc;
	}

	public void setcFacPrc(String cFacPrc) {
		this.cFacPrc = cFacPrc;
	}

	public String getcFacShr() {
		return cFacShr;
	}

	public void setcFacShr(String cFacShr) {
		this.cFacShr = cFacShr;
	}

	public String getRetX() {
		if("0.00000".equals(retX))
			return "0";
		return retX;
	}

	public void setRetX(String retX) {
		this.retX = retX;
	}

	public Integer getExchTrd() {
		return exchTrd;
	}

	public void setExchTrd(Integer exchTrd) {
		this.exchTrd = exchTrd;
	}

	public Integer getStkTrd() {
		return stkTrd;
	}

	public void setStkTrd(Integer stkTrd) {
		this.stkTrd = stkTrd;
	}
	
}
