package com.example.spring.surveymonkey.typereference;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.surveymonkey.dto.Member;
import com.example.spring.surveymonkey.dto.Pager;

public final class MembersType
		extends ParameterizedTypeReference<Pager<Member>> {

}
