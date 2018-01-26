/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.manager;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cn.edu.saif.shared.manager.rest.RestClient;

/**
 * Rest Manager
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see Exception
 */
public class RestManager extends AbstractManager implements RestClient {

	protected RestTemplate restTemplate;

	public RestManager(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public <T> T getForObject(String url,
			ParameterizedTypeReference<T> responseType,
			Map<String, ?> urlVariables) {
		ResponseEntity<T> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, null, responseType, urlVariables);
		return responseEntity.getBody();
	}

	@Override
	public <T> T getForObject(String url,
			ParameterizedTypeReference<T> responseType, Object... urlVariables) {
		ResponseEntity<T> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, null, responseType, urlVariables);
		return responseEntity.getBody();
	}

	@Override
	public <T> T postForObject(String url, Object request,
			ParameterizedTypeReference<T> responseType,
			Map<String, ?> uriVariables) {
		HttpEntity<?> requestEntity = new HttpEntity<Object>(request);
		ResponseEntity<T> responseEntity = restTemplate.exchange(url,
				HttpMethod.POST, requestEntity, responseType, uriVariables);
		return responseEntity.getBody();
	}

	@Override
	public <T> T postForObject(String url, Object request,
			ParameterizedTypeReference<T> responseType, Object... uriVariables) {
		HttpEntity<?> requestEntity = new HttpEntity<Object>(request);
		ResponseEntity<T> responseEntity = restTemplate.exchange(url,
				HttpMethod.POST, requestEntity, responseType, uriVariables);
		return responseEntity.getBody();
	}

	@Override
	public <T> T getForObject(String url, Class<T> responseType,
			Map<String, ?> urlVariables) {
		return restTemplate.getForObject(url, responseType, urlVariables);
	}

	@Override
	public <T> T getForObject(String url, Class<T> responseType,
			Object... urlVariables) {
		return restTemplate.getForObject(url, responseType, urlVariables);
	}

	@Override
	public <T> T postForObject(String url, Object request,
			Class<T> responseType, Map<String, ?> uriVariables) {
		return restTemplate.postForObject(url, request, responseType,
				uriVariables);
	}

	@Override
	public <T> T postForObject(String url, Object request,
			Class<T> responseType, Object... uriVariables) {
		return restTemplate.postForObject(url, request, responseType,
				uriVariables);
	}
}
