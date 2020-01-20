package com.example.spring.surveymonkey.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shared {

	@JsonProperty("workgroup_id")
	String workgroupId;

	@JsonProperty
	List<String> privileges = new ArrayList<>();

	@JsonProperty("share_id")
	String shareId;

	@JsonProperty("resource_type")
	String resourceType;

	@JsonProperty("resource_id")
	String resourceId;

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

}
