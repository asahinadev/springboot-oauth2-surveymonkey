package com.example.spring.surveymonkey.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.ErrorResponce;
import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.type.ErrorResponceType;

@Controller
@RequestMapping("/errors")
public class ErrorsController {

	final SurveymonkeyApi api;

	@Autowired
	public ErrorsController(SurveymonkeyApi api) {
		this.api = api;
	}

	@GetMapping("")
	public String index(Model model) {
		Pagenate<ErrorResponce> errors = api.get("/v3/errors", ErrorResponceType.LIST);
		model.addAttribute("errors", errors);
		return "errors/index";
	}

	@GetMapping("{id}")
	public String group(Model model, @PathVariable Map<String, String> pathValue) {
		ErrorResponce error = api.get("/v3/errors/{id}", pathValue, ErrorResponceType.SINGLE);
		model.addAttribute("error", error);
		return "errors/form";
	}

}
