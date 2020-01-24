package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.MemberResponce;
import com.example.spring.surveymonkey.dto.Pagenate;

public final class MemberResponceType {
	public static final ParameterizedTypeReference<MemberResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<MemberResponce>> LIST = new CommonType<>();
}
