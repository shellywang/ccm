/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.domain.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Base DTE
 *
 * @author Xiao GuangLei
 * @since 1.0
 */

@JsonInclude(Include.NON_NULL)
@MappedSuperclass
public class BaseDTE {

	// 创建ID
	@Column(name = "CreateID")
	@JsonIgnore
	private Integer createID;

	// 创建时间
	@Column(name = "CreateTS")
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	private Date createTS = new Date();

	// 更新ID
	@Column(name = "UpdateID")
	@JsonIgnore
	private Integer updateID;

	// 更新时间
	@Column(name = "UpdateTS")
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	private Date updateTS = new Date();

	// 记录状态 1：有效 0：无效
	@Column(name = "Status")
	@JsonIgnore
	private String status = "1";

	public int getCreateID() {
		return createID;
	}

	public void setCreateID(int createID) {
		this.createID = createID;
	}

	public Date getCreateTS() {
		return createTS;
	}

	public void setCreateTS(Date createTS) {
		this.createTS = createTS;
	}

	public int getUpdateID() {
		return updateID;
	}

	public void setUpdateID(int updateID) {
		this.updateID = updateID;
	}

	public Date getUpdateTS() {
		return updateTS;
	}

	public void setUpdateTS(Date updateTS) {
		this.updateTS = updateTS;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
