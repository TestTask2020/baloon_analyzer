package test.task.baloon.consumer.model;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Weather {
	private LocalDateTime timeStamp;
	private Location location;
	private Integer temperature;
	private Observatory observatory;
	
	public Weather() {
	}
	
	public Weather(final LocalDateTime timeStamp, final Location location, final Integer temperature, final Observatory observatory) {
		this.timeStamp = timeStamp;
		this.location = location;
		this.temperature = temperature;
		this.observatory = observatory;
	}
	
	public LocalDateTime getTimeStamp() {
		return this.timeStamp;
	}
	
	public void setTimeStamp(final LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(final Location location) {
		this.location = location;
	}
	
	public Integer getTemperature() {
		return this.temperature;
	}
	
	public void setTemperature(final Integer temperature) {
		this.temperature = temperature;
	}
	
	public Observatory getObservatory() {
		return this.observatory;
	}
	
	public void setObservatory(final Observatory observatory) {
		this.observatory = observatory;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", Weather.class.getSimpleName() + "[", "]")
				.add("timeStamp=" + timeStamp)
				.add("location=" + location)
				.add("temperature=" + temperature)
				.add("observatory=" + observatory)
				.toString();
	}
}
