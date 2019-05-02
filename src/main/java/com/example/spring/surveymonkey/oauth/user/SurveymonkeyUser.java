package com.example.spring.surveymonkey.oauth.user;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveymonkeyUser
		implements OAuth2User {

	public static final String ID = "id";
	public static final String USERNAME = "username";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String LANGUAGE = "language";
	public static final String EMAIL = "email";
	public static final String EMAIL_VERIFIED = "email_verified";
	public static final String ACCOUNT_TYPE = "account_type";
	public static final String DATE_CREATED = "date_created";
	public static final String DATE_LAST_LOGIN = "date_last_login";
	public static final String SCOPES = "scopes";
	public static final String SCOPES__AVAILABLE = "available";
	public static final String SCOPES__GRANTED = "granted";

	@JsonProperty(SCOPES)
	Map<String, List<String>> scopes = new HashMap<>();

	@JsonAnySetter
	Map<String, Object> extraParameters = new HashMap<>();

	@Override
	@JsonIgnore
	public String getName() {
		return getAttributes().get(ID).toString();
	}

	public String getEmail() {
		return getAttributes().get(EMAIL).toString();
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
		attribute.put(SCOPES, getScopes());
		return Collections.unmodifiableMap(attribute);
	}

	@Override
	public String toString() {
		return getAttributes().toString();
	}

}
