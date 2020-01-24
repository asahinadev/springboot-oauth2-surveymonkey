package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.dto.SharedResponce;

public final class SharedResponceType {
	public static final ParameterizedTypeReference<SharedResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<SharedResponce>> LIST = new CommonType<>();
}
