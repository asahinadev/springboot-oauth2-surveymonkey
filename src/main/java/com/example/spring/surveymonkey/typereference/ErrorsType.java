package com.example.spring.surveymonkey.typereference;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.ErrorDto;
import com.example.spring.surveymonkey.dto.Pager;

public final class ErrorsType
		extends ParameterizedTypeReference<Pager<ErrorDto>> {

}
