package com.example.spring.surveymonkey.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.dto.Shared;
import com.example.spring.surveymonkey.dto.User;
import com.example.spring.surveymonkey.dto.Workgroup;
import com.example.spring.surveymonkey.typereference.SharedsType;
import com.example.spring.surveymonkey.typereference.UserType;
import com.example.spring.surveymonkey.typereference.WorkgroupsType;

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
		User user = api.get("/v3/users/me", Collections.emptyMap(), new UserType());
		model.addAttribute("user", user);
		return "users/index";
	}

	@GetMapping("workgroups")
	public RedirectView workgroups() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new RedirectView(UriComponentsBuilder.fromPath("/users/{id}/workgroups").build(authentication.getName()).getPath());
	}

	@GetMapping("shared")
	public RedirectView shared() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new RedirectView(UriComponentsBuilder.fromPath("/users/{id}/shared").build(authentication.getName()).getPath());
	}

	@GetMapping("{id}/workgroups")
	public String workgroups(Model model, @PathVariable Map<String, String> pathValue) {
		Pager<Workgroup> workgroups = api.get("/v3/users/{id}/workgroups", pathValue, new WorkgroupsType());
		model.addAttribute("workgroups", workgroups);
		return "users/workgroups";
	}

	@GetMapping("{id}/shared")
	public String shared(Model model, @PathVariable Map<String, String> pathValue) {
		Pager<Shared> shareds = api.get("/v3/users/{id}/shared", pathValue, new SharedsType());
		model.addAttribute("shareds", shareds);
		return "users/shared";
	}
}
