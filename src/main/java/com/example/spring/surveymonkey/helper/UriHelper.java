package com.example.spring.surveymonkey.helper;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

public class UriHelper {

	public static URI uri(String url) {
		return uri(url, Collections.emptyMap());
	}

	public static URI uri(String url, Map<String, String> pathValues) {
		return UriComponentsBuilder.fromHttpUrl(url).build(pathValues);
	}

	public static URI uri(String url, Object... pathValues) {
		return UriComponentsBuilder.fromHttpUrl(url).build(pathValues);
	}

	public static String path(String url) {
		return path(url, Collections.emptyMap());
	}

	public static String path(String url, Map<String, String> pathValues) {
		return uri(url, pathValues).getPath();
	}

	public static String path(String url, Object... pathValues) {
		return uri(url, pathValues).getPath();
	}
}
