/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.service;

import cn.edu.saif.ccm.domain.dto.user.auth.AuthDTO;
import cn.edu.saif.shared.common.BaseException;

/**
 * Auth Service Inteface
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see AuthService
 */
public interface AuthService {

	/**
	 * check AccessToken.
	 * 
	 * @return AuthDTO
	 * @throws BaseException
	 */
	public AuthDTO checkAccessToken(String accessToken) throws BaseException;

	/**
	 * check RefreshToken.
	 * 
	 * @return AuthDTO
	 * @throws BaseException
	 */
	public AuthDTO checkRefreshToken(String refreshToken) throws BaseException;

}
