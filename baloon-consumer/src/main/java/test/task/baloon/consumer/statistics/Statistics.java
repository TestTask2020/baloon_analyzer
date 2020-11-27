package test.task.baloon.consumer.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import test.task.baloon.consumer.weather.model.Location;
import test.task.baloon.consumer.weather.model.Observatory;

public class Statistics {
	private int minimumTemperature;
	private int maximumTemperature;
	private int meanTemperature;
	private Map<Observatory, Integer> observationsCounts = new HashMap<>();
	private double totalDistance;
	
	// always in KM
	private Double lastX;
	private Double lastY;
	
	public Statistics() {
	}
	
	public Statistics(final int minimumTemperature, final int maximumTemperature, final int meanTemperature,
					  final Map<Observatory, Integer> observationsCounts, final int totalDistance) {
		this.minimumTemperature = minimumTemperature;
		this.maximumTemperature = maximumTemperature;
		this.meanTemperature = meanTemperature;
		this.observationsCounts = observationsCounts;
		this.totalDistance = totalDistance;
	}
	
	public int getMinimumTemperature() {
		return this.minimumTemperature;
	}
	
	public void setMinimumTemperature(final int minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}
	
	public int getMaximumTemperature() {
		return this.maximumTemperature;
	}
	
	public void setMaximumTemperature(final int maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	
	public int getMeanTemperature() {
		return this.meanTemperature;
	}
	
	public void setMeanTemperature(final int meanTemperature) {
		this.meanTemperature = meanTemperature;
	}
	
	public Map<Observatory, Integer> getObservationsCounts() {
		return new HashMap<>(this.observationsCounts);
	}
	
	public void updateObsevationsNumber(Observatory observatory) {
		Integer count = observationsCounts.get(observatory);
		if (count == null) {
			observationsCounts.put(observatory, 0);
		} else {
			observationsCounts.put(observatory, count + 1);
		}
	}
	
	public double getTotalDistance() {
		return this.totalDistance;
	}
	
	public void setTotalDistance(final double totalDistance) {
		this.totalDistance = totalDistance;
	}
	
	public Double getLastX() {
		return this.lastX;
	}
	
	public void setLastX(final Double lastX) {
		this.lastX = lastX;
	}
	
	public Double getLastY() {
		return this.lastY;
	}
	
	public void setLastY(final Double lastY) {
		this.lastY = lastY;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", Statistics.class.getSimpleName() + "[", "]")
				.add("minimumTemperature=" + minimumTemperature)
				.add("maximumTemperature=" + maximumTemperature)
				.add("meanTemperature=" + meanTemperature)
				.add("observationsCounts=" + observationsCounts)
				.add("totalDistance=" + totalDistance)
				.add("lastPoint=" + lastX)
				.toString();
	}
}
