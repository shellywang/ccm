/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.ccm.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web Mvc Config
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see WebMvcConfig
 */
@Configuration
@ComponentScan(basePackages = { "cn.edu.saif.ccm.rest" })
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver mpartResolver = new CommonsMultipartResolver();
//		mpartResolver.setMaxUploadSize(1048576);// 1M Byte
		return mpartResolver;
	}
}