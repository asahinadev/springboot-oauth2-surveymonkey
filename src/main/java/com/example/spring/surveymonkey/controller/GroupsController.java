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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.surveymonkey.dto.Group;
import com.example.spring.surveymonkey.dto.Member;
import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.dto.User;

@RequestMapping("/groups")
@Controller
public class GroupsController {

	final OAuth2AuthorizedClientService clientService;

	@ResponseBody
	@ExceptionHandler(HttpClientErrorException.class)
	public String exceptionHandler(HttpClientErrorException exception) {
		return exception.getMessage();
	}

	@Autowired
	public GroupsController(OAuth2AuthorizedClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("")
	public String index(Model model, @AuthenticationPrincipal User user) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/groups").build().toUri());

		ResponseEntity<Pager<Group>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Pager<Group>>() {
				});

		model.addAttribute("groups", responseEntity.getBody());
		return "groups/index";
	}

	@GetMapping("{id}")
	public String group(Model model, @AuthenticationPrincipal User user, @PathVariable("id") Long id) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/groups/{id}")
						.build(Maps.of("id", id)));

		ResponseEntity<Group> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Group>() {
				});

		model.addAttribute("group", responseEntity.getBody());

		return "users/group";
	}

	@GetMapping("{id}/members")
	public String members(Model model, @AuthenticationPrincipal User user, @PathVariable("id") Long id) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/groups/{id}/members")
						.build(Maps.of("id", id)));

		ResponseEntity<Pager<Member>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Pager<Member>>() {
				});

		model.addAttribute("members", responseEntity.getBody());

		return "users/members";
	}

	@GetMapping("{id}/members/{mid}")
	public String members(Model model, @AuthenticationPrincipal User user,
			@PathVariable("id") Long id, @PathVariable("mid") Long mid) {

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("surveymonkey", user.getId());

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(client.getAccessToken().getTokenValue());

		RequestEntity<?> requestEntity = new RequestEntity<>(
				headers,
				HttpMethod.GET,
				UriComponentsBuilder.fromHttpUrl("https://api.surveymonkey.com/v3/groups/{id}/members")
						.build(Maps.of("id", id, "mid", mid)));

		ResponseEntity<Pager<Member>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Pager<Member>>() {
				});

		model.addAttribute("member", responseEntity.getBody());

		return "users/member";
	}

}
