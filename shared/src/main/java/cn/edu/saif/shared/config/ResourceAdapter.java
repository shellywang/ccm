/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.config;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.transaction.compensating.manager.TransactionAwareContextSourceProxy;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import cn.edu.saif.shared.manager.RedisManager;
import cn.edu.saif.shared.manager.RestManager;

/**
 * Resource Adapter
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see ResourceAdapter
 */
@Configuration
@EnableCaching
public class ResourceAdapter {

	final static Logger logger = LoggerFactory.getLogger(ResourceAdapter.class);

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JavaMailSenderImpl mailAdapter() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(env.getProperty("smtp.host"));
		mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
		mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
		mailSenderImpl.setUsername(env.getProperty("smtp.username"));
		mailSenderImpl.setPassword(env.getProperty("smtp.password"));

		Properties javaMailProps = new Properties();
		javaMailProps.put("mail.smtp.auth", true);
//		javaMailProps.put("mail.smtp.starttls.enable", true);

		mailSenderImpl.setJavaMailProperties(javaMailProps);
		return mailSenderImpl;
	}

	// @Bean
	// public JmsManager jmsAdapter() {
	// JmsTemplate jmsTemplate = new JmsTemplate();
	//
	// ActiveMQConnectionFactory activeMQConnectionFactory = new
	// ActiveMQConnectionFactory();
	// activeMQConnectionFactory
	// .setBrokerURL(env.getProperty("jms.brokerurl"));
	//
	// SingleConnectionFactory connectionFactory = new SingleConnectionFactory(
	// activeMQConnectionFactory);
	//
	// jmsTemplate.setConnectionFactory(connectionFactory);
	//
	// jmsListener(connectionFactory);
	//
	// return new JmsManager(jmsTemplate);
	// }
	//
	// public void jmsListener(SingleConnectionFactory connectionFactory) {
	// DefaultMessageListenerContainer defaultMessageListenerContainer = new
	// DefaultMessageListenerContainer();
	// defaultMessageListenerContainer.setMessageListener(new JmsListener());
	// ActiveMQQueue activeMQQueue = new ActiveMQQueue("queue.message");
	// defaultMessageListenerContainer.setDestination(activeMQQueue);
	// defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
	// defaultMessageListenerContainer.start();
	// }

	@Bean
	public LdapTemplate ldapAdapter() {
		LdapContextSource ldapContextSource = new LdapContextSource();
		ldapContextSource.setUrl(env.getProperty("ldap.url"));
		ldapContextSource.setBase(env.getProperty("ldap.base"));
		ldapContextSource.setUserDn(env.getProperty("ldap.userdn"));
		ldapContextSource.setPassword(env.getProperty("ldap.password"));

		TransactionAwareContextSourceProxy transactionAwareContextSourceProxy = new TransactionAwareContextSourceProxy(
				ldapContextSource);

		LdapTemplate ldapTemplate = new LdapTemplate(
				transactionAwareContextSourceProxy);

		return ldapTemplate;
	}

//	@Bean
//	public SearchManager searchManager() {
//		SearchManager searchManager = new SearchManager();
//		@SuppressWarnings("unused")
//		SolrServer server = new HttpSolrServer(env.getProperty("solr.url"));
//
//		searchManager.setUrl(env.getProperty("solr.url"));
//
//		return searchManager;
//	}

	@Bean
	public RedisManager redisManager() {
		/*
		 * Jedis jedis = new Jedis(env.getProperty("cache.url"),
		 * Integer.parseInt(env.getProperty("cache.port")));
		 */
		JedisPool pool = null;
		if (pool == null) {
			logger.info("***************initial redis poll connection start************************");
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxTotal(Integer.parseInt(env
					.getProperty("redis.maxtotal")));
			logger.info("***************MaxTotal:"
					+ env.getProperty("redis.maxtotal")
					+ "************************");
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(Integer.parseInt(env.getProperty("redis.maxidle")));
			logger.info("***************MaxIdle:"
					+ env.getProperty("redis.maxidle")
					+ "************************");
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(Integer.parseInt(env
					.getProperty("redis.maxwaitmillis")));
			logger.info("***************MaxWaitMillis:"
					+ env.getProperty("redis.maxwaitmillis")
					+ "************************");
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			pool = new JedisPool(config, env.getProperty("redis.url"),
					Integer.parseInt(env.getProperty("redis.port")));
			logger.info("***************JedisPool URL:"
					+ env.getProperty("redis.url") + ",Port"
					+ env.getProperty("redis.port")
					+ "************************");

			logger.info("***************initial redis poll connection done************************");
		}
		RedisManager cacheManager = new RedisManager(pool);

		return cacheManager;
	}

	@Bean
	public RestManager RestAdapter() {
		return new RestManager(new RestTemplate());
	}

}
