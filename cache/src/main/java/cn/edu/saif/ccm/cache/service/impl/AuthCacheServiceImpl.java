/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.cache.service.impl;

import java.util.List;

import org.apache.http.client.AuthCache;
import org.springframework.stereotype.Service;

import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.ccm.cache.BaseAbstractCache;
import cn.edu.saif.ccm.cache.CacheKeys;
import cn.edu.saif.ccm.cache.service.AuthCacheService;

/**
 * Auth Cache Implementation
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see AuthCache
 */
@Service
public class AuthCacheServiceImpl extends BaseAbstractCache implements AuthCacheService {

	@Override
	public List<String> getAuthbyAccessToken(String accessToken)
			throws BaseException {

		return this.getTokenListByKey(CacheKeys.KEY_USER_SESSION_ACCESS_POINT
				+ accessToken);

	}

	@Override
	public List<String> getAccessTokenByRefreshToken(String refreshToken)
			throws BaseException {
		return null;
	}

	@Override
	public Long refreshAccessToken(String accessToken) throws BaseException {
		return this.expireKey(CacheKeys.KEY_USER_SESSION_ACCESS_POINT
				+ accessToken, CacheKeys.KEY_USER_SESSION_ACCESS_POINT_EXPIRE);
	}

}
