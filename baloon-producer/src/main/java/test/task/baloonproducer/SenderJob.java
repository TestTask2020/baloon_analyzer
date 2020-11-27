package test.task.baloonproducer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import test.task.baloonproducer.model.Weather;
import test.task.baloonproducer.utils.WeatherUtils;

@Component
public class SenderJob {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SenderJob.class);
	
	private final RabbitTemplate rabbitTemplate;
	
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	
	
	@Autowired
	public SenderJob(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Scheduled(cron = "*/100 * * * * *")
	public void generateTestData() {
		List<String> weatherList = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			weatherList.add(WeatherUtils.formatWeather(WeatherUtils.generateWeather()));
		}
		for (final String weatherString : weatherList) {
			rabbitTemplate.convertAndSend(BaloonProducerApplication.topicExchangeName, "baloon.data.weather",
					weatherString);
		}
		
	}


}
