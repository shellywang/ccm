/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.cache.service;

import java.util.List;

import cn.edu.saif.shared.common.BaseException;

/**
 * Auth Cache Service
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see AuthCache
 */
public interface AuthCacheService {

	public List<String> getAuthbyAccessToken(String accessToken)
			throws BaseException;

	public List<String> getAccessTokenByRefreshToken(String refreshToken)
			throws BaseException;

	public Long refreshAccessToken(String accessToken) throws BaseException;

}
