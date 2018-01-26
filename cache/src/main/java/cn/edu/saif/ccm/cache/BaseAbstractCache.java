/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import cn.edu.saif.ccm.domain.dto.user.auth.AuthDTO;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.ErrorCode;
import cn.edu.saif.shared.common.ErrorDTO;
import cn.edu.saif.shared.manager.RedisManager;

/**
 * Description
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see BaseAbstractCache
 */
public abstract class BaseAbstractCache {

	protected AuthDTO authDTO;

	public void setAuth(AuthDTO authDTO) throws BaseException {
		this.authDTO = authDTO;
	}

	@Autowired
	private RedisManager redisManager;

	/** Value */
	protected Boolean checkKeyExist(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		boolean boo = Jedis.exists(key);
		redisManager.returnResource(Jedis);
		return boo;
	}

	protected Long genIdByKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		long lon = Jedis.incr(key);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected Long delByKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		long lon = Jedis.incr(key);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected String renameKey(String oldKey, String newKey)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.rename(oldKey, newKey);
		redisManager.returnResource(Jedis);
		return string;
	}

	protected Long expireKey(String key, int seconds) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		long lon = Jedis.expire(key, seconds);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected Long ttlKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		long lon = Jedis.ttl(key);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected Set<String> getKeysByPattern(String pattern) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		Set<String> set = Jedis.keys(pattern);
		redisManager.returnResource(Jedis);
		return set;
	}

	/** String */
	protected String getStringValueByKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.get(key);
		redisManager.returnResource(Jedis);
		return string;
	}
	
	protected String setStringValueByKey(String key, String value)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.set(key, value);
		redisManager.returnResource(Jedis);
		return string;
	}

	protected List<String> getMultipleValueByKey(String keys[])
			throws BaseException {
		String stringKeys = "";
		for (int i = 0; i < keys.length; i++) {
			if (i < (keys.length - 1))
				stringKeys += keys[i] + ",";
			else
				stringKeys += keys[i];
		}
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.mget(stringKeys);
		redisManager.returnResource(Jedis);
		return list;
	}

	protected String setStringValueWithExpireByKey(String key, int seconds,
			String value) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.setex(key, seconds, value);
		redisManager.returnResource(Jedis);
		return string;
	}

	/** List */
	// 在名称为key的list头添加一个值为value的 元素
	protected Long setBottemValueByListKey(String key, String value)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		Long lon = Jedis.lpush(key, value);
		redisManager.returnResource(Jedis);
		return lon;
	}

	// 在名称为key的list尾添加一个值为value的元素
	protected Long setTopValueByListKey(String key, String value)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		Long lon = Jedis.rpush(key, value);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected List<String> getRangeByListKey(String key, int start, int end)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.lrange(key, start, end);
		redisManager.returnResource(Jedis);
		return list;
	}

	protected String getTrimByListKey(String key, int start, int end)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.ltrim(key, start, end);
		redisManager.returnResource(Jedis);
		return string;
	}

	protected Long getLengthByListKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		Long lon = Jedis.llen(key);
		redisManager.returnResource(Jedis);
		return lon;
	}

	//获取指定数据
	protected String getIndexStringByListKey(String key, long index) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String message = Jedis.lindex(key, index);
		redisManager.returnResource(Jedis);
		return message;
	}

	// 返回并删除名称为key的list中的首元素
	protected String getTopStringByListKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String message = Jedis.lpop(key);
		redisManager.returnResource(Jedis);
		return message;
	}

	// 返回并删除名称为key的list中的首元素
	protected String getBottemStringByListKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String message = Jedis.rpop(key);
		redisManager.returnResource(Jedis);
		return message;

	}

	// 给指定下标的list设置值
	protected String setListvalueByListKey(String key, Long index, String value)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.lset(key, index, value);
		redisManager.returnResource(Jedis);
		return string;

	}

	/** Set */

	/** Hash */
	protected String getStringValueByHashKey(String key, String hashKey)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.hget(key, hashKey);
		redisManager.returnResource(Jedis);
		return string;
	}

	protected Long setStringValueByHashKey(String key, String hashKey,
			String value) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		long lon = Jedis.hset(key, hashKey, value);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected List<String> getTokenListByKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.hmget(key, "UserNum", "UserType",
				"BusinessID");
		redisManager.returnResource(Jedis);
		return list;
	}

	protected List<String> getEventStatListByHashKey(String key)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.hmget(key, "TotalCnt", "ViewedCnt",
				"CompletedCnt");
		redisManager.returnResource(Jedis);
		return list;
	}

	protected List<String> getMultipleHashValueByKey(String key,
			String hashKeys[]) throws BaseException {
		if (hashKeys == null || hashKeys.length == 0)
			return null;
		String hashStringKeys = "";
		for (int i = 0; i < hashKeys.length; i++) {
			if (i < (hashKeys.length - 1))
				hashStringKeys += hashKeys[i] + ",";
			else
				hashStringKeys += hashKeys[i];
		}
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.hmget(key, hashStringKeys);
		redisManager.returnResource(Jedis);
		return list;
	}

	protected String setMultipleHashValueByKey(String key,
			Map<String, String> hashMap) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		String string = Jedis.hmset(key, hashMap);
		redisManager.returnResource(Jedis);
		return string;
	}

	protected Map<String, String> getAllListByHashKey(String hashKey)
			throws BaseException {
		return redisManager.getJedis().hgetAll(hashKey);
	}

	protected List<String> getAllValuesByHashKey(String hashKey)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.hvals(hashKey);
		redisManager.returnResource(Jedis);
		return list;
	}

	protected List<String> getAllListByKey(String key) throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		List<String> list = Jedis.lrange(key, 0, -1);
		redisManager.returnResource(Jedis);
		return list;
	}

	protected Boolean checkHashKeyExists(String key, String hashKey)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		boolean boo = Jedis.hexists(key, hashKey);
		redisManager.returnResource(Jedis);
		return boo;
	}

	protected Long delHashKeyExists(String key, String hashKey)
			throws BaseException {
		Jedis Jedis = redisManager.getJedis();
		long lon = Jedis.hdel(key, hashKey);
		redisManager.returnResource(Jedis);
		return lon;
	}

	protected Transaction getTransaction() {
		return redisManager.getJedis().multi();
	}

	protected CacheException getCacheFailedException() {
		return new CacheException(new ErrorDTO(ErrorCode.CACHE_FAIL_CODE,
				ErrorCode.CACHE_FAIL_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	protected BaseException getCacheFailedBaseException() {
		return new BaseException(new ErrorDTO(ErrorCode.CACHE_FAIL_CODE,
				ErrorCode.CACHE_FAIL_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	protected BaseException getDataIllegalBaseException() {
		return new BaseException(new ErrorDTO(ErrorCode.DATA_ILLEGAL_CODE,
				ErrorCode.DATA_ILLEGAL_MSG, HttpStatus.INTERNAL_SERVER_ERROR));
	}
}
