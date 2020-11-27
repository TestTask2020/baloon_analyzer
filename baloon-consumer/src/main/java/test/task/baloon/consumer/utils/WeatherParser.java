package test.task.baloon.consumer.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.task.baloon.consumer.model.Location;
import test.task.baloon.consumer.model.Observatory;
import test.task.baloon.consumer.model.Weather;

public class WeatherParser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherParser.class);
	
	private static final String DATE_TIME_PATTERN = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	
	// 2014-12-31T13:44|10,5|243|AU
	public static Weather parseWeather(String weatherString) {
		if (weatherString == null) {
			LOGGER.debug("Can not parse null weather");
			return null;
		}
		String[] weatherFields = weatherString.split("\\|");
		if (weatherFields.length < 4) {
			LOGGER.debug("Can not parse broken data: {}", weatherString);
			return null;
		}
		LocalDateTime timestamp = getTimestamp(weatherFields[0]);
		Location location = parseLocation(weatherFields[1]);
		Integer temperature = getTemperature(weatherFields[2]);
		Observatory observatory = Observatory.of(weatherFields[3]);
		return new Weather(timestamp, location, temperature, observatory);
	}
	
	private static Integer getTemperature(String temperatureString) {
		if (temperatureString.matches("\\d+")) {
			return Integer.parseInt(temperatureString);
		} else {
			LOGGER.debug("Can not parse temperature: {}", temperatureString);
			return null;
		}
	}
	
	private static Location parseLocation(String locationString) {
		if (locationString.matches("\\d+,\\d+")) {
			String[] locationFields = locationString.split(",");
			return new Location(Integer.valueOf(locationFields[0]), Integer.valueOf(locationFields[1]));
		} else {
			LOGGER.debug("Can not parse location: {}", locationString);
			return null;
		}
	}
	
	private static LocalDateTime getTimestamp(final String weatherField) {
		if (weatherField.matches(DATE_TIME_PATTERN)) {
			return LocalDateTime.parse(weatherField, FORMATTER);
		} else {
			LOGGER.debug("Timestamp does not match the pattern. Pattern: {}, timestamp: {}", DATE_TIME_PATTERN, weatherField);
			return null;
		}
	}
	
}
