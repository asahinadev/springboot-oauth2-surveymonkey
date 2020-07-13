package com.example.spring.surveymonkey.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.spring.surveymonkey.api.*;
import com.example.spring.surveymonkey.dto.*;
import com.example.spring.surveymonkey.helper.*;
import com.example.spring.surveymonkey.type.*;

@RequestMapping("/users")
@Controller
public class UsersController {

	final SurveymonkeyApi api;

	@Autowired
	public UsersController(SurveymonkeyApi api) {
		this.api = api;
	}

	@GetMapping("me")
	public String me(Model model) {
		UserResponce user = api.get("/v3/users/me", UserResponceType.SINGLE);
		model.addAttribute("user", user);
		return "users/index";
	}

	@GetMapping("workgroups")
	public String workgroups() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "redirect:" + UriHelper.path("/users/{id}/workgroups", authentication.getName());
	}

	@GetMapping("shared")
	public String shared() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "redirect:" + UriHelper.path("/users/{id}/shared", authentication.getName());
	}

	@GetMapping("{id}/workgroups")
	public String workgroups(Model model, @PathVariable Map<String, String> pathValue) {
		Pagenate<WorkgroupResponce> workgroups = api.get("/v3/users/{id}/workgroups", pathValue, WorkgroupResponceType.LIST);
		model.addAttribute("workgroups", workgroups);
		return "users/workgroups";
	}

	@GetMapping("{id}/shared")
	public String shared(Model model, @PathVariable Map<String, String> pathValue) {
		Pagenate<SharedResponce> shareds = api.get("/v3/users/{id}/shared", pathValue, SharedResponceType.LIST);
		model.addAttribute("shareds", shareds);
		return "users/shared";
	}
}
