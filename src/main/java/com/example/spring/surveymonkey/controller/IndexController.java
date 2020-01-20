package com.example.spring.surveymonkey.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.surveymonkey.dto.User;

@RequestMapping("/")
@Controller
public class IndexController {

	@GetMapping
	public String index(Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("user", user);
		return "index";
	}
}
