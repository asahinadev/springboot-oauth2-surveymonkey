package com.example.spring.surveymonkey.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.spring.surveymonkey.helper.UriHelper;

@Service
public class SurveymonkeyApi {

	final OAuth2AuthorizedClientService clientService;

	final RestTemplate restTemplate = new RestTemplate();

	final String prefix = "https://api.surveymonkey.com";

	@Autowired
	public SurveymonkeyApi(OAuth2AuthorizedClientService clientService) {
		super();
		this.clientService = clientService;
	}

	public <T> T get(String url, Map<String, String> pathValue, ParameterizedTypeReference<T> typeReference) {
		HttpHeaders headers = headers();
		RequestEntity<?> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, UriHelper.uri(prefix + url, pathValue));
		ResponseEntity<T> responseEntity = restTemplate.exchange(requestEntity, typeReference);
		return responseEntity.getBody();
	}

	protected HttpHeaders headers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", authentication.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());
		return headers;
	}
}
