package com.example.spring.surveymonkey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.dto.RoleResponce;
import com.example.spring.surveymonkey.type.RoleResponceType;

@Controller
@RequestMapping("/roles")
public class RolesController {

	final SurveymonkeyApi api;

	@Autowired
	public RolesController(SurveymonkeyApi api) {
		this.api = api;
	}

	@GetMapping("")
	public String index(Model model) {
		Pagenate<RoleResponce> roles = api.get("/v3/roles", RoleResponceType.LIST);
		model.addAttribute("roles", roles);
		return "roles/index";
	}

}
