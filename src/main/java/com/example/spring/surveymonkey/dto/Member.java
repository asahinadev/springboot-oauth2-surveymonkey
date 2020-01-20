package com.example.spring.surveymonkey.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {

	@JsonProperty("is_owner")
	Boolean owner;

	@JsonProperty
	String status;

	@JsonProperty("user_id")
	String userId;

	@JsonProperty
	String username;

}
