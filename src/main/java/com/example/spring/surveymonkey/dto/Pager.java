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
public class Pager<E> {

	@JsonProperty
	Long page;

	@JsonProperty
	Map<String, String> links = new HashMap<String, String>();

	@JsonProperty("per_page")
	Long perPage;

	@JsonProperty
	Long total;

	@JsonProperty
	List<E> data = new ArrayList<E>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

}
