package cn.edu.saif.ccm.domain.bond;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "CCM_GBOND_DESC")
@JsonInclude(Include.NON_NULL)
public class GBondDesc implements Serializable{

	private static final long serialVersionUID = -7929256827615768116L;

	@Id
	@Column(name = "BONDCODE", nullable = false)
	private String bondCode;
	
	@Column(name = "FULLNAME", nullable = false)
	private String fullName;
	
	@Column(name = "ISSUE_ADATE")
	private Date issueADate;
	
	@Column(name = "ISSUE_FDATE", nullable = false)
	private Date issueFDate;
	
	@Column(name = "ISSUE_LDATE", nullable = false)
	private Date issueLDate;
	
	@Column(name = "ISSUE_AMOUNTPLAN")
	private String issueAPlan;
	
	@Column(name = "ISSUE_AMOUNTACT", nullable = false)
	private String issueAAct;
	
	@Column(name = "ISSUE_PRICE", nullable = false)
	private String issuePrice;
	
	@Column(name = "PAR", nullable = false)
	private int par;
	
	@Column(name = "COUPONRATE")
	private String couponRate;
	
	@Column(name = "SPREAD")
	private String spread;
	
	@Column(name = "CARRYDATE", nullable = false)
	private Date carryDate;
	
	@Column(name = "ENDDATE", nullable = false)
	private Date endDate;
	
	@Column(name = "MATURITYDATE", nullable = false)
	private Date matDate;
	
	@Column(name = "TERMYEAR", nullable = false)
	private String termYear;
	
	@Column(name = "TERMDAY", nullable = false)
	private int termDay;
	
	@Column(name = "PAYMENTDATE", nullable = false)
	private Date paymentDate;
	
	@Column(name = "PAYMENTTYPE")
	private String paymentType;
	
	@Column(name = "INTERESTFREQUENCY")
	private String interFreq;
	
	@Column(name = "FORM")
	private Integer form;
	
	@Column(name = "COUPON")
	private String coupon;
	
	@Column(name = "INTERESTTYPE")
	private String interType;
	
	@Column(name = "ACT")
	private Integer act;
	
	@Column(name = "ISSUE_FEE")
	private String issueFee;
	
	@Column(name = "REDEMPTION_FEERATION")
	private String redemptionFee;
	
	@Column(name = "TAXRATE")
	private String taxRate;
	
	@Column(name = "CRNCY_CODE", nullable = false)
	private String crncyCode;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "EXCHMARKET", nullable = false)
	private String exchMarket;
	
	@Column(name = "GUARANTOR")
	private String guarantor;
	
	@Column(name = "GUARTYPE")
	private Integer guarType;
	
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@Column(name = "TYPE2")
	private String type2;

	public String getBondCode() {
		return bondCode;
	}

	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getIssueADate() {
		return issueADate;
	}

	public void setIssueADate(Date issueADate) {
		this.issueADate = issueADate;
	}

	public Date getIssueFDate() {
		return issueFDate;
	}

	public void setIssueFDate(Date issueFDate) {
		this.issueFDate = issueFDate;
	}

	public Date getIssueLDate() {
		return issueLDate;
	}

	public void setIssueLDate(Date issueLDate) {
		this.issueLDate = issueLDate;
	}

	public String getIssueAPlan() {
		return issueAPlan;
	}

	public void setIssueAPlan(String issueAPlan) {
		this.issueAPlan = issueAPlan;
	}

	public String getIssueAAct() {
		return issueAAct;
	}

	public void setIssueAAct(String issueAAct) {
		this.issueAAct = issueAAct;
	}

	public String getIssuePrice() {
		return issuePrice;
	}

	public void setIssuePrice(String issuePrice) {
		this.issuePrice = issuePrice;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public String getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(String couponRate) {
		this.couponRate = couponRate;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public Date getCarryDate() {
		return carryDate;
	}

	public void setCarryDate(Date carryDate) {
		this.carryDate = carryDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getMatDate() {
		return matDate;
	}

	public void setMatDate(Date matDate) {
		this.matDate = matDate;
	}

	public String getTermYear() {
		return termYear;
	}

	public void setTermYear(String termYear) {
		this.termYear = termYear;
	}

	public int getTermDay() {
		return termDay;
	}

	public void setTermDay(int termDay) {
		this.termDay = termDay;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getInterFreq() {
		return interFreq;
	}

	public void setInterFreq(String interFreq) {
		this.interFreq = interFreq;
	}

	public Integer getForm() {
		return form;
	}

	public void setForm(Integer form) {
		this.form = form;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getInterType() {
		return interType;
	}

	public void setInterType(String interType) {
		this.interType = interType;
	}

	public Integer getAct() {
		return act;
	}

	public void setAct(Integer act) {
		this.act = act;
	}

	public String getIssueFee() {
		return issueFee;
	}

	public void setIssueFee(String issueFee) {
		this.issueFee = issueFee;
	}

	public String getRedemptionFee() {
		return redemptionFee;
	}

	public void setRedemptionFee(String redemptionFee) {
		this.redemptionFee = redemptionFee;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getCrncyCode() {
		return crncyCode;
	}

	public void setCrncyCode(String crncyCode) {
		this.crncyCode = crncyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExchMarket() {
		return exchMarket;
	}

	public void setExchMarket(String exchMarket) {
		this.exchMarket = exchMarket;
	}

	public String getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	public Integer getGuarType() {
		return guarType;
	}

	public void setGuarType(Integer guarType) {
		this.guarType = guarType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
}
