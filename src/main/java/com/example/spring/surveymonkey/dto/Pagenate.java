package com.example.spring.surveymonkey.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagenate<E> {

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Links {
		@JsonProperty
		String self;
		@JsonProperty
		String prev;
		@JsonProperty
		String next;
		@JsonProperty
		String last;
	}

	@JsonProperty
	Long page;
	@JsonProperty("per_page")
	Long perPage;
	@JsonProperty
	Long total;
	@JsonProperty
	List<E> data = new ArrayList<E>();
	@JsonProperty
	Links links;

	@JsonAnySetter
	Map<String, Object> extraParameters;

}
