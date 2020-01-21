package com.example.spring.surveymonkey.helper;

import java.net.URI;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

public class UriHelper {

	public static URI uri(String url) {
		return UriComponentsBuilder.fromHttpUrl(url).build().toUri();
	}

	public static URI uri(String url, Map<String, String> pathValues) {
		return UriComponentsBuilder.fromHttpUrl(url).build(pathValues);
	}
}
