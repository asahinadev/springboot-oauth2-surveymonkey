package com.example.spring.surveymonkey.serializer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OffsetDateTimeDeserializer
		extends JsonDeserializer<OffsetDateTime> {

	final DateTimeFormatter formatter;

	protected OffsetDateTimeDeserializer(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	@SneakyThrows
	public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt) {

		ObjectCodec codec = p.getCodec();
		JsonNode tree = codec.readTree(p);
		String value = tree.textValue();

		log.debug("value : {}", value);

		return OffsetDateTime.parse(value, formatter);
	}

	public static class IsoOffsetDateTime extends OffsetDateTimeDeserializer {

		protected IsoOffsetDateTime() {
			super(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}

	}

}
