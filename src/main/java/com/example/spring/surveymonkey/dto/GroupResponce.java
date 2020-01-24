package com.example.spring.surveymonkey.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupResponce {

	@JsonProperty
	String id;

	@JsonProperty
	String name;

	@JsonProperty
	String href;

	@JsonProperty("member_count")
	Long memberCount;

	@JsonProperty("max_invites")
	Long maxInvites;

	@JsonProperty("date_created")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	LocalDateTime dateCreated;

}
