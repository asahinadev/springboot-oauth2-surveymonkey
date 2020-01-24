package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.dto.UserResponce;

public final class UserResponceType {
	public static final ParameterizedTypeReference<UserResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<UserResponce>> LIST = new CommonType<>();
}
