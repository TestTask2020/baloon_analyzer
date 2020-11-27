package test.task.baloon.consumer.statistics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.task.baloon.consumer.weather.WeatherRepository;
import test.task.baloon.consumer.weather.model.Weather;

@RestController
public class StatisticsController {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@GetMapping("/weather-history")
	List<Weather> getWeatherList(@RequestParam String dateFrom, @RequestParam String dateTo) {
		return weatherRepository.findWeatherByTimeStampBetween(
				LocalDateTime.parse(dateFrom, FORMATTER),
				LocalDateTime.parse(dateTo, FORMATTER));
	}

}
