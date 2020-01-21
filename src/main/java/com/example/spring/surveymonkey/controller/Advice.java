package com.example.spring.surveymonkey.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class Advice {

	@ResponseBody
	@ExceptionHandler(HttpClientErrorException.class)
	public String exceptionHandler(HttpClientErrorException exception) {
		return exception.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(HttpServerErrorException.class)
	public String exceptionHandler(HttpServerErrorException exception) {
		return exception.getResponseBodyAsString();
	}

}
