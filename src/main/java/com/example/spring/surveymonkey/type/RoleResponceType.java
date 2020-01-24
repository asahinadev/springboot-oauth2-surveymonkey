package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.dto.RoleResponce;

public final class RoleResponceType {
	public static final ParameterizedTypeReference<RoleResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<RoleResponce>> LIST = new CommonType<>();
}
