package com.example.spring.surveymonkey.typereference;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Group;
import com.example.spring.surveymonkey.dto.Pager;

public final class GroupsType
		extends ParameterizedTypeReference<Pager<Group>> {

}
