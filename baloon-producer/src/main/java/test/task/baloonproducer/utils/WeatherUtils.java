package test.task.baloonproducer.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.StringJoiner;

import test.task.baloonproducer.model.Location;
import test.task.baloonproducer.model.Observatory;
import test.task.baloonproducer.model.Weather;

public class WeatherUtils {
	
	private static final Random RANDOM = new Random();
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	
	public static Weather generateWeather() {
		return new Weather(
				LocalDateTime.now(ZoneOffset.UTC),
				new Location(RANDOM.nextInt(90), RANDOM.nextInt(90)),
				RANDOM.nextInt(100),
				getRandomObservatory()
		);
	}
	
	private static Observatory getRandomObservatory() {
		int n = RANDOM.nextInt(Observatory.values().length + 1);
		if (n < Observatory.values().length) {
			return Observatory.values()[n];
		} else {
			return null;
		}
	}
	
	public static String formatWeather(Weather weather) {
		return new StringJoiner("|")
				.add(formatTimestamp(weather))
				.add(formatLocation(weather))
				.add(weather.getTemperature().toString())
				.add(formatObservatory(weather))
				.toString();
	}
	
	private static String formatTimestamp(final Weather weather) {
		return FORMATTER.format(weather.getTimeStamp());
	}
	
	private static String formatLocation(final Weather weather) {
		return weather.getLocation().getX() + "," + weather.getLocation().getY();
	}
	
	private static String formatObservatory(final Weather weather) {
		return weather.getObservatory() != null ? weather.getObservatory().toString() : null;
	}
	
}
