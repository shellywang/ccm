/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.service;

import cn.edu.saif.ccm.domain.dto.user.auth.AuthDTO;
import cn.edu.saif.shared.common.BaseException;

/**
 * Base Service
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see BaseService
 */
public interface BaseService {

	/**
	 * setAuth
	 * 
	 * @param AuthDTO
	 * @exception BaseException
	 */
	public void setAuth(AuthDTO authDTO) throws BaseException;

}
