package com.example.spring.surveymonkey.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

	@JsonProperty
	String id;

	@JsonProperty
	String name;

	@JsonProperty("is_enabled")
	Boolean enabled;

	@JsonProperty
	String description;

	@JsonProperty
	Map<String, Object> metadata = new HashMap<>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

}
