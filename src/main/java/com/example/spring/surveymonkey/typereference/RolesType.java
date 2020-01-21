package com.example.spring.surveymonkey.typereference;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.dto.Role;

public final class RolesType
		extends ParameterizedTypeReference<Pager<Role>> {

}
