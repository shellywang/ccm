/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis Manager
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see RedisManager
 */
public class RedisManager extends AbstractManager {

	final static Logger logger = LoggerFactory.getLogger(RedisManager.class);
	private JedisPool pool = null;

	public RedisManager(JedisPool pool) {
		this.pool = pool;
	}

	private JedisPool getPool() {
		return pool;
	}

	public Jedis getJedis() {
		try {
			return getPool().getResource();
		} catch (Exception e) {
			logger.info("get redis resource failed, retry");
			return getPool().getResource();
		}
	}

	/**
	 * 返还到连接池
	 * 
	 * @param pool
	 * @param redis
	 */
	public Jedis getResource() {
		try {
			return getPool().getResource();
		} catch (Exception e) {
			System.out.println("get redis resource failed, retry");
			return getPool().getResource();
		}
	}

	/**
	 * 返还到连接池
	 * 
	 * @param redis
	 */
	public void returnBrokenResource(Jedis redis) {
		if (redis != null) {
			pool.returnBrokenResource(redis);
		}
	}

	/**
	 * 返还到连接池
	 * 
	 * @param pool
	 * @param redis
	 */
	public void returnResource(Jedis redis) {
		if (redis != null) {
			pool.returnResource(redis);
		}
	}

}
