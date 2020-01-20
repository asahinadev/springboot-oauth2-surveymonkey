package com.example.spring.surveymonkey.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workgroup {

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
	Role defaultRole;

	@JsonProperty("created_at")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime createdAt;

	@JsonProperty("updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime updatedAt;

	@JsonProperty
	List<Shared> shares = new ArrayList<>();

	@JsonProperty("shares_count")
	Long sharesCount;

	@JsonProperty
	Member membership;

	@JsonProperty
	List<Member> members = new ArrayList<>();

	@JsonProperty
	Map<String, Object> metadata = new HashMap<>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

}
