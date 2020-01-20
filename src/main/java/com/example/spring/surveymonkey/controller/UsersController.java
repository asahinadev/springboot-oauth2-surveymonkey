package com.example.spring.surveymonkey.controller;

import org.apache.groovy.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.surveymonkey.dto.User;
import com.example.spring.surveymonkey.dto.Workgroup;
import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.dto.Shared;

@RequestMapping("/users")
@Controller
public class UsersController {

	final OAuth2AuthorizedClientService clientService;

	@ResponseBody
	@ExceptionHandler(HttpClientErrorException.class)
	public String exceptionHandler(HttpClientErrorException exception) {
		return exception.getMessage();
	}

	@Autowired
	public UsersController(OAuth2AuthorizedClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("me")
	public String me(Model model, @AuthenticationPrincipal User user) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/users/me").build().toUri());

		ResponseEntity<User> responseEntity = restTemplate.exchange(requestEntity, User.class);

		model.addAttribute("user", responseEntity.getBody());
		return "users/index";
	}

	@GetMapping("workgroups")
	public String workgroups(Model model, @AuthenticationPrincipal User user) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/users/{id}/workgroups")
						.build(Maps.of("id", user.getId())));

		ResponseEntity<Pager<Workgroup>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Pager<Workgroup>>() {
				});

		model.addAttribute("workgroups", responseEntity.getBody());

		return "users/workgroups";
	}

	@GetMapping("shared")
	public String shared(Model model, @AuthenticationPrincipal User user) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/users/{id}/shared")
						.build(Maps.of("id", user.getId())));

		ResponseEntity<Pager<Shared>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Pager<Shared>>() {
				});

		model.addAttribute("shared", responseEntity.getBody());

		return "users/shared";
	}
}
