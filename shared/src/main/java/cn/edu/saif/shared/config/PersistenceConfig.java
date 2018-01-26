/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.edu.saif.shared.ftp.MyFtpClient;

/**
 * Persistence Config
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see PersistenceConfig
 */
@Configuration
@Profile(value = "prod")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "cn.edu.saif.ccm.persistence.repositories" })
public class PersistenceConfig {

	final static Logger logger = LoggerFactory
			.getLogger(PersistenceConfig.class);

	@Autowired
	private Environment env;

	@Value("${init-db:false}")
	private String initDatabase;

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);

		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("cn.edu.saif.ccm.domain.dto");
		factory.setPackagesToScan("cn.edu.saif.ccm.domain");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto",
				env.getProperty("hibernate.hbm2ddl.auto"));
		factory.setJpaProperties(jpaProperties);

		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

//	@Bean
//	public DataSource dataSource() {
//		DataSource dataSource = null;
//		try {
//			InitialContext ctx = new InitialContext();
//			logger.info("Datasource name:" + env.getProperty("jdbc.jndi"));
//			dataSource = (DataSource) ctx.lookup("myJDBC");
//		} catch (NamingException e) {
//			e.printStackTrace();
//			logger.error("Get datasource exception");
//		}
//		return dataSource;
//	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(dataSource());
		return jt;
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		logger.info("**************************" + initDatabase);
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("ccm.sql"));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
		return dataSourceInitializer;
	}
	
	@Bean
	public MyFtpClient ftpClient(){
		MyFtpClient.setHostname(env.getProperty("ftp.host"));
		MyFtpClient.setPort(env.getProperty("ftp.port",Integer.class));
		MyFtpClient.setUsername(env.getProperty("ftp.username"));
		MyFtpClient.setPassword(env.getProperty("ftp.password"));
		MyFtpClient ftpClient=new MyFtpClient();
		try {
			ftpClient.setBufferSize(1024);
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("FtpClient setFileType exception");
		}
		return ftpClient;
	}
}
