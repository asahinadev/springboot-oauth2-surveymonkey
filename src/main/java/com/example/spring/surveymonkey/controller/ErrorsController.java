package com.example.spring.surveymonkey.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.ErrorDto;
import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.typereference.ErrorType;
import com.example.spring.surveymonkey.typereference.ErrorsType;

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
		Pager<ErrorDto> errors = api.get("/v3/errors", Collections.emptyMap(), new ErrorsType());
		model.addAttribute("errors", errors);
		return "errors/index";
	}

	@GetMapping("{id}")
	public String group(Model model, @PathVariable Map<String, String> pathValue) {
		ErrorDto error = api.get("/v3/errors/{id}", pathValue, new ErrorType());
		model.addAttribute("error", error);
		return "errors/form";
	}

}
