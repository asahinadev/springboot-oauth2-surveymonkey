package com.example.spring.surveymonkey.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {

	@JsonProperty
	String id;

	@JsonProperty
	String message;

	@JsonProperty
	String href;

	@JsonProperty
	String name;

	@JsonProperty
	String docs;

}
