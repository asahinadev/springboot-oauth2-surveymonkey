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
import com.example.spring.surveymonkey.dto.Group;
import com.example.spring.surveymonkey.dto.Member;
import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.typereference.GroupType;
import com.example.spring.surveymonkey.typereference.GroupsType;
import com.example.spring.surveymonkey.typereference.MemberType;
import com.example.spring.surveymonkey.typereference.MembersType;

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
		Pager<Group> groups = api.get("/v3/groups", Collections.emptyMap(), new GroupsType());
		model.addAttribute("groups", groups);
		return "groups/index";
	}

	@GetMapping("{id}")
	public String group(Model model, @PathVariable Map<String, String> pathValue) {
		Group group = api.get("/v3/groups/{id}", pathValue, new GroupType());
		model.addAttribute("group", group);
		return "groups/form";
	}

	@GetMapping("{id}/members")
	public String members(Model model, @PathVariable Map<String, String> pathValue) {
		Pager<Member> members = api.get("/v3/groups/{id}/members", pathValue, new MembersType());
		model.addAttribute("members", members);
		return "users/members";
	}

	@GetMapping("{id}/members/{uid}")
	public String member(Model model, @PathVariable Map<String, String> pathValue) {
		Member member = api.get("/v3/groups/{id}/members/{uid}", pathValue, new MemberType());
		model.addAttribute("member", member);
		return "groups/member";
	}

}
