/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.domain.dto.user.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Auth DTO
 *
 * @author Xiao GuangLei
 * @since 1.0
 */
@JsonInclude(Include.NON_NULL)
public class AuthDTO {
	// 访问令牌
	private String accessToken;
	private String accessExpiredDate;
	// 刷新令牌
	private String refreshToken;
	private String refreshExpiredDate;

	// 用户号
	private String userNum;
	// 用户类型，T：老师，C：联系人
	private String userType;
	// 实体ID（老师ID或联系人ID）
	private int businessID;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessExpiredDate() {
		return accessExpiredDate;
	}

	public void setAccessExpiredDate(String accessExpiredDate) {
		this.accessExpiredDate = accessExpiredDate;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getRefreshExpiredDate() {
		return refreshExpiredDate;
	}

	public void setRefreshExpiredDate(String refreshExpiredDate) {
		this.refreshExpiredDate = refreshExpiredDate;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getBusinessID() {
		return businessID;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

}
