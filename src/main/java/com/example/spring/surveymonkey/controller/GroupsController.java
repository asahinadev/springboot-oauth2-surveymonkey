package com.example.spring.surveymonkey.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.surveymonkey.api.SurveymonkeyApi;
import com.example.spring.surveymonkey.dto.GroupResponce;
import com.example.spring.surveymonkey.dto.MemberResponce;
import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.type.GroupResponceType;
import com.example.spring.surveymonkey.type.MemberResponceType;

@Controller
@RequestMapping("/groups")
public class GroupsController {

	final SurveymonkeyApi api;

	@Autowired
	public GroupsController(SurveymonkeyApi api) {
		this.api = api;
	}

	@GetMapping("")
	public String index(Model model) {
		Pagenate<GroupResponce> groups = api.get("/v3/groups", GroupResponceType.LIST);
		model.addAttribute("groups", groups);
		return "groups/index";
	}

	@GetMapping("{id}")
	public String group(Model model, @PathVariable Map<String, String> pathValue) {
		GroupResponce group = api.get("/v3/groups/{id}", pathValue, GroupResponceType.SINGLE);
		model.addAttribute("group", group);
		return "groups/form";
	}

	@GetMapping("{id}/members")
	public String members(Model model, @PathVariable Map<String, String> pathValue) {
		Pagenate<MemberResponce> members = api.get("/v3/groups/{id}/members", pathValue, MemberResponceType.LIST);
		model.addAttribute("members", members);
		return "users/members";
	}

	@GetMapping("{id}/members/{uid}")
	public String member(Model model, @PathVariable Map<String, String> pathValue) {
		MemberResponce member = api.get("/v3/groups/{id}/members/{uid}", pathValue, MemberResponceType.SINGLE);
		model.addAttribute("member", member);
		return "groups/member";
	}

}
