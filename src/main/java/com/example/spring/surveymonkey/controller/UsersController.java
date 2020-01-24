package com.example.spring.surveymonkey.controller;

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

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.dto.SharedResponce;
import com.example.spring.surveymonkey.dto.UserResponce;
import com.example.spring.surveymonkey.dto.WorkgroupResponce;
import com.example.spring.surveymonkey.helper.UriHelper;
import com.example.spring.surveymonkey.type.SharedResponceType;
import com.example.spring.surveymonkey.type.UserResponceType;
import com.example.spring.surveymonkey.type.WorkgroupResponceType;

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
	public RedirectView workgroups() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new RedirectView(UriHelper.path("/users/{id}/workgroups", authentication.getName()));
	}

	@GetMapping("shared")
	public RedirectView shared() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new RedirectView(UriHelper.path("/users/{id}/shared", authentication.getName()));
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
