package com.example.spring.surveymonkey.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTimeSerializer
		extends JsonSerializer<LocalDateTime> {

	final DateTimeFormatter formatter;

	protected LocalDateTimeSerializer(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public void serialize(
			LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		log.debug("value : {}", value);
		String writeValue = value.format(formatter);
		log.debug("value : {}", writeValue);

		gen.writeString(writeValue);
	}

	public static class IsoLocalDateTime extends LocalDateTimeSerializer {

		protected IsoLocalDateTime() {
			super(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		}

	}

}
