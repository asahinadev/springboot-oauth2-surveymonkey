package com.example.spring.surveymonkey.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.SneakyThrows;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User
		implements OAuth2User {

	@JsonProperty
	String id;

	@JsonProperty
	String username;

	@JsonProperty("first_name")
	String firstName;

	@JsonProperty("last_name")
	String lastName;

	@JsonProperty("account_type")
	String accountType;

	@JsonProperty
	String language;

	@JsonProperty
	String email;

	@JsonProperty("email_verified")
	Boolean emailVerified;

	@JsonProperty
	String href;

	@JsonProperty("date_last_login")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
	LocalDateTime dateLastLogin;

	@JsonProperty("date_created")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	LocalDateTime dateCreated;

	@JsonProperty("scopes")
	Map<String, List<String>> scopes = new HashMap<>();

	@JsonProperty("sso_connections")
	List<String> ssoConnections = new ArrayList<>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

	@Override
	public String getName() {
		return getId();
	}

	@Override
	@JsonIgnore
	public List<GrantedAuthority> getAuthorities() {
		return Arrays.asList(
				new OAuth2UserAuthority("USER", getAttributes()),
				new SimpleGrantedAuthority("USER"));
	}

	@Override
	@JsonIgnore
	public Map<String, Object> getAttributes() {

		Map<String, Object> attribute = new HashMap<>(this.getExtraParameters());
		attribute.put("scopes", getScopes());

		return Collections.unmodifiableMap(attribute);
	}

	@SneakyThrows
	public String toString() {
		return new ObjectMapper().writeValueAsString(this);
	}

}
