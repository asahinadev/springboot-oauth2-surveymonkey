package com.example.spring.surveymonkey.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.dto.Role;
import com.example.spring.surveymonkey.typereference.RolesType;

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
		Pager<Role> roles = api.get("/v3/roles", Collections.emptyMap(), new RolesType());
		model.addAttribute("roles", roles);
		return "roles/index";
	}

}
