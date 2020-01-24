package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.ErrorResponce;
import com.example.spring.surveymonkey.dto.Pagenate;

public final class ErrorResponceType {
	public static final ParameterizedTypeReference<ErrorResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<ErrorResponce>> LIST = new CommonType<>();
}
