package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.GroupResponce;
import com.example.spring.surveymonkey.dto.Pagenate;

public final class GroupResponceType {
	public static final ParameterizedTypeReference<GroupResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<GroupResponce>> LIST = new CommonType<>();
}
