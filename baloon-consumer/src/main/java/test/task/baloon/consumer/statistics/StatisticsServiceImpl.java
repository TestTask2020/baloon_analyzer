package test.task.baloon.consumer.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import test.task.baloon.consumer.weather.model.Observatory;
import test.task.baloon.consumer.weather.model.Weather;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsServiceImpl.class);
	
	private static final Statistics STATISTICS = new Statistics();
	
	@Override
	public void updateStatistics(Weather weather) {
		synchronized (STATISTICS) {
			STATISTICS.setMinimumTemperature(calculateMinimumTemperature(STATISTICS, weather));
			STATISTICS.setMaximumTemperature(calculateMaximumTemperature(STATISTICS, weather));
			STATISTICS.setMeanTemperature(calculateMeanTemperature(STATISTICS));
			STATISTICS.updateObsevationsNumber(weather.getObservatory());
			if (weather.getLocation() != null) {
				if (STATISTICS.getLastX() != null && STATISTICS.getLastY() != null) {
					STATISTICS.setTotalDistance(calculateTotalDistance(STATISTICS, weather));
					STATISTICS.setLastX(toKm(weather.getLocation().getX(), weather.getObservatory()));
					STATISTICS.setLastX(toKm(weather.getLocation().getY(), weather.getObservatory()));
				}
			}
			LOGGER.debug("Updated statistics: {}", STATISTICS);
		}
	}
	
	private Integer calculateMinimumTemperature(final Statistics statistics, final Weather weather) {
		int min = statistics.getMinimumTemperature();
		Integer weatherTemperature = weather.getTemperature();
		return weatherTemperature == null || min < weatherTemperature ? min : weatherTemperature;
	}
	
	private Integer calculateMaximumTemperature(final Statistics statistics, final Weather weather) {
		int max = statistics.getMinimumTemperature();
		Integer weatherTemperature = weather.getTemperature();
		return weatherTemperature == null || max > weatherTemperature ? max : weatherTemperature;
	}
	
	private Integer calculateMeanTemperature(final Statistics statistics) {
		return (statistics.getMaximumTemperature() + statistics.getMinimumTemperature()) / 2;
	}
	
	private double calculateTotalDistance(final Statistics statistics, final Weather weather) {
		Double x1 = statistics.getLastX();
		double x2 = toKm(weather.getLocation().getX(), weather.getObservatory());
		Double y1 = statistics.getLastY();
		double y2 = toKm(weather.getLocation().getY(), weather.getObservatory());
		return statistics.getTotalDistance() + Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
	
	private double toKm(final Integer coordinate, Observatory observatory) {
		if (observatory == Observatory.AU) {
			return coordinate;
		}
		if (observatory == Observatory.FR) {
			return coordinate + 1000; // M to KM
		}
		if (observatory == Observatory.US) {
			return coordinate * 1.60934;
		}
		return coordinate;
	}
	
}
