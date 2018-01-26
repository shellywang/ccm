package cn.edu.saif.ccm.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.edu.saif.ccm.connector.APIService;
import cn.edu.saif.ccm.connector.impl.APIServiceImpl;

@Configuration
@ComponentScan(basePackages = { "cn.edu.saif.ccm.rest" })
@EnableWebMvc
public class WebMvcConfigTest extends WebMvcConfigurerAdapter {
	@Bean
	public APIService apiService() {
		return new APIServiceImpl();
	}
}