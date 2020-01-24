package com.example.spring.surveymonkey.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.surveymonkey.serializer.DateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkgroupResponce {

	@JsonProperty
	String id;

	@JsonProperty
	String name;

	@JsonProperty("is_visible")
	Boolean visible;

	@JsonProperty("members_count")
	Long membersCount;

	@JsonProperty
	String description;

	@JsonProperty("default_role")
	RoleResponce defaultRole;

	@JsonProperty("created_at")
	@JsonSerialize(converter = DateTimeSerializer.LOCAL.class)
	LocalDateTime createdAt;

	@JsonProperty("updated_at")
	@JsonSerialize(converter = DateTimeSerializer.LOCAL.class)
	LocalDateTime updatedAt;

	@JsonProperty
	List<SharedResponce> shares = new ArrayList<>();

	@JsonProperty("shares_count")
	Long sharesCount;

	@JsonProperty
	MemberResponce membership;

	@JsonProperty
	List<MemberResponce> members = new ArrayList<>();

	@JsonProperty
	Map<String, Object> metadata = new HashMap<>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

}
