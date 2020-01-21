package com.example.spring.surveymonkey.typereference;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Pager;
import com.example.spring.surveymonkey.dto.Workgroup;

public final class WorkgroupsType
		extends ParameterizedTypeReference<Pager<Workgroup>> {

}
