package com.example.spring.surveymonkey.serializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OffsetDateTimeSerializer
		extends JsonSerializer<OffsetDateTime> {

	final DateTimeFormatter formatter;

	protected OffsetDateTimeSerializer(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public void serialize(
			OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		log.debug("value : {}", value);
		String writeValue = value.format(formatter);
		log.debug("value : {}", writeValue);

		gen.writeString(writeValue);
	}

	public static class IsoOffsetDateTime extends OffsetDateTimeSerializer {

		protected IsoOffsetDateTime() {
			super(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}

	}

}
