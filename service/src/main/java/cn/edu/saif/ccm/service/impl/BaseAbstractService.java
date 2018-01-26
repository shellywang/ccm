/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.service.impl;

import org.springframework.http.HttpStatus;

import cn.edu.saif.ccm.domain.dto.user.auth.AuthDTO;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.ErrorCode;
import cn.edu.saif.shared.common.ErrorDTO;

/**
 * Base Abstract Service
 *
 * @author Xiao GuangLei
 * @since 1.0
 */
public abstract class BaseAbstractService {

	protected AuthDTO authDTO;

	public void setAuth(AuthDTO authDTO) throws BaseException {
		this.authDTO = authDTO;
	}

	protected BaseException getDataIllegalBaseException() {
		return new BaseException(new ErrorDTO(ErrorCode.DATA_ILLEGAL_CODE,
				ErrorCode.DATA_ILLEGAL_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	protected BaseException getDataBaseFailBaseException() {
		return new BaseException(new ErrorDTO(ErrorCode.DATABASE_FAIL_CODE,
				ErrorCode.DATABASE_FAIL_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	protected BaseException getCacheFailBaseException(ErrorDTO err) {
		return new BaseException(err);
	}

	protected BaseException getCacheFailBaseException() {
		return new BaseException(new ErrorDTO(ErrorCode.CACHE_FAIL_CODE,
				ErrorCode.CACHE_FAIL_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	protected BaseException getSysException() {
		return new BaseException(new ErrorDTO(ErrorCode.SYSTEM_ANOMALY_CODE,
				ErrorCode.SYSTEM_ANOMALY_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
