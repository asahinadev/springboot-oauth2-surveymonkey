package com.example.spring.surveymonkey.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.surveymonkey.serializer.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

	@JsonProperty
	String id;

	@JsonProperty
	String name;

	@JsonProperty("is_enabled")
	boolean enabled;

	@JsonProperty("is_system_role")
	boolean systemRole;

	@JsonProperty
	String description;

	@JsonProperty
	List<String> privileges = new ArrayList<>();

	@JsonProperty("created_at")
	@JsonSerialize(using = LocalDateTimeSerializer.IsoLocalDateTime.class)
	LocalDateTime createdAt;

	@JsonProperty("updated_at")
	@JsonSerialize(using = LocalDateTimeSerializer.IsoLocalDateTime.class)
	LocalDateTime updatedAt;

	@JsonProperty
	Map<String, Object> metadata = new HashMap<>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

}
