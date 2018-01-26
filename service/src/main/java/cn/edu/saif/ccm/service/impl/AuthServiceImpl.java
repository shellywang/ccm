/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cn.edu.saif.ccm.cache.service.AuthCacheService;
import cn.edu.saif.ccm.domain.dto.user.auth.AuthDTO;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.ErrorCode;
import cn.edu.saif.shared.common.ErrorDTO;
import cn.edu.saif.ccm.service.AuthService;

/**
 * Auth Service Implementation
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see AuthServiceImpl
 */
@Service
public class AuthServiceImpl implements AuthService {

	final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	protected AuthCacheService authCacheService;

	@Override
	public AuthDTO checkAccessToken(String accessToken) throws BaseException {
		logger.debug("[AuthServiceImpl:checkAccessToken] Begin ==> Accesstoken:"
				+ accessToken);
		if (StringUtils.isBlank(accessToken)) {
			throw new BaseException(new ErrorDTO(ErrorCode.SESSION_ERROR_CODE,
					ErrorCode.SESSION_ERROR_MSG, HttpStatus.UNAUTHORIZED));
		}

		// 获取会话信息
		List<String> list = authCacheService.getAuthbyAccessToken(accessToken);
		AuthDTO authDTO = null;
		if (list != null && list.size() == 3) {
			logger.debug("[AuthServiceImpl:checkAccessToken] get HashKey OK, token:"
					+ accessToken);
			logger.debug("[AuthServiceImpl:checkAccessToken] get HashKey OK, List:"
					+ list.get(0) + "//" + list.get(1) + "//" + list.get(2));
			if (list.get(0) == null) {
				throw new BaseException(new ErrorDTO(
						ErrorCode.SESSION_USER_PWD_ERROR_CODE,
						ErrorCode.SESSION_USER_PWD_ERROR_MSG,
						HttpStatus.UNAUTHORIZED));
			}

			authDTO = new AuthDTO();
			authDTO.setAccessToken(accessToken);
			authDTO.setUserNum(list.get(0));
			authDTO.setUserType(list.get(1));

			try {
				authDTO.setBusinessID(Integer.parseInt(list.get(2)));
			} catch (Exception e) {
				logger.debug("[AuthServiceImpl:checkAccessToken] Parse businessID error, token:"
						+ accessToken);
				throw new BaseException(new ErrorDTO(
						ErrorCode.SESSION_ERROR_CODE,
						ErrorCode.SESSION_ERROR_MSG, HttpStatus.FORBIDDEN), e);
			}
		} else {
			throw new BaseException(new ErrorDTO(
					ErrorCode.SESSION_CONVERSATIOM_PAST_CODE,
					ErrorCode.SESSION_CONVERSATIOM_PAST_MSG,
					HttpStatus.FORBIDDEN));
		}
		// 刷新过期时间
		authCacheService.refreshAccessToken(accessToken);
		return authDTO;
	}

	@Override
	public AuthDTO checkRefreshToken(String refreshToken) throws BaseException {
		return null;
	}

}
