package cn.edu.saif.shared.manager.rest;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;

public interface RestClient{
	
	<T> T getForObject(String url, ParameterizedTypeReference<T> responseType, Object... urlVariables);
	<T> T getForObject(String url, ParameterizedTypeReference<T> responseType, Map<String, ?> urlVariables);
	
	<T> T postForObject(String url, Object request, ParameterizedTypeReference<T> responseType, Object... uriVariables);
	<T> T postForObject(String url, Object request, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables);
	
	<T> T getForObject(String url, Class<T> responseType, Object... urlVariables);
	<T> T getForObject(String url, Class<T> responseType, Map<String, ?> urlVariables);
		
	<T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables);
	<T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables);

}

