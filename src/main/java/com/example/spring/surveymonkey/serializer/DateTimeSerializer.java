package com.example.spring.surveymonkey.serializer;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

import com.fasterxml.jackson.databind.util.StdConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTimeSerializer
		extends StdConverter<Temporal, String> {

	final DateTimeFormatter formatter;

	protected DateTimeSerializer(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public String convert(Temporal value) {

		log.debug("value : {}", value);
		if (value == null) {
			return null;
		}

		String writeValue = formatter.format(value);
		log.debug("value : {}", writeValue);

		return writeValue;
	}

	public static class LOCAL extends DateTimeSerializer {

		protected LOCAL() {
			super(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		}

	}

	public static class OFFSET extends DateTimeSerializer {

		protected OFFSET() {
			super(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}

	}

}
