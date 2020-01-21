package com.example.spring.surveymonkey.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class Advice {

	@ResponseBody
	@ExceptionHandler(HttpClientErrorException.class)
	public String exceptionHandler(HttpClientErrorException exception) {
		return exception.getMessage();
	}

}
