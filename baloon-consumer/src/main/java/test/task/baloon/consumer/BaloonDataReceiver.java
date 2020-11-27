package test.task.baloon.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import test.task.baloon.consumer.utils.WeatherParser;

@Component
public class BaloonDataReceiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherParser.class);
	
	public void receiveMessage(String message) {
		LOGGER.debug("Received message: {}", message);
		LOGGER.info("Received weather: {}", WeatherParser.parseWeather(message));
	}

}
