package test.task.baloon.consumer.statistics;

import java.util.Map;

import test.task.baloon.consumer.weather.model.Observatory;

public class Statistics {
	private Integer minimumTemperature;
	private Integer maximumTemperature;
	private Integer meanTemperature;
	private Map<Observatory, Integer> observationsNumber;
	private Integer totalDistance;
	
	public Statistics() {
	}
	
	public Statistics(final Integer minimumTemperature, final Integer maximumTemperature, final Integer meanTemperature,
					  final Map<Observatory, Integer> observationsNumber, final Integer totalDistance) {
		this.minimumTemperature = minimumTemperature;
		this.maximumTemperature = maximumTemperature;
		this.meanTemperature = meanTemperature;
		this.observationsNumber = observationsNumber;
		this.totalDistance = totalDistance;
	}
	
	public Integer getMinimumTemperature() {
		return this.minimumTemperature;
	}
	
	public void setMinimumTemperature(final Integer minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}
	
	public Integer getMaximumTemperature() {
		return this.maximumTemperature;
	}
	
	public void setMaximumTemperature(final Integer maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	
	public Integer getMeanTemperature() {
		return this.meanTemperature;
	}
	
	public void setMeanTemperature(final Integer meanTemperature) {
		this.meanTemperature = meanTemperature;
	}
	
	public Map<Observatory, Integer> getObservationsNumber() {
		return this.observationsNumber;
	}
	
	public void setObservationsNumber(final Map<Observatory, Integer> observationsNumber) {
		this.observationsNumber = observationsNumber;
	}
	
	public Integer getTotalDistance() {
		return this.totalDistance;
	}
	
	public void setTotalDistance(final Integer totalDistance) {
		this.totalDistance = totalDistance;
	}
}
