package test.task.baloon.consumer.statistics;

import test.task.baloon.consumer.weather.model.Weather;

public interface StatisticsService {
	
	void updateStatistics(Weather weather);
	
}
