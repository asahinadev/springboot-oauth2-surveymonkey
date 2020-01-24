package com.example.spring.surveymonkey.type;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Pagenate;
import com.example.spring.surveymonkey.dto.WorkgroupResponce;

public final class WorkgroupResponceType {
	public static final ParameterizedTypeReference<WorkgroupResponce> SINGLE = new CommonType<>();
	public static final ParameterizedTypeReference<Pagenate<WorkgroupResponce>> LIST = new CommonType<>();
}
