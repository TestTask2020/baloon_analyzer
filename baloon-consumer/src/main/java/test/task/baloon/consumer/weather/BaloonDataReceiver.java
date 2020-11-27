package test.task.baloon.consumer.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.task.baloon.consumer.statistics.StatisticsService;
import test.task.baloon.consumer.weather.model.Weather;
import test.task.baloon.consumer.weather.utils.WeatherParser;

@Component
public class BaloonDataReceiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherParser.class);
	
	@Autowired
	private StatisticsService statisticsService;
	
	public void receiveMessage(String message) {
		LOGGER.debug("Received message: {}", message);
		Weather weather = WeatherParser.parseWeather(message);
		LOGGER.debug("Received weather: {}", weather);
		statisticsService.updateStatistics(weather);
	}

}
