package test.task.baloon.consumer.weather.model;

import java.time.LocalDateTime;
import java.util.StringJoiner;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weather {
	
	@Id
	@GeneratedValue
	private Long weatherId;
	private LocalDateTime timeStamp;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride( name = "x", column = @Column(name = "location_x")),
			@AttributeOverride( name = "y", column = @Column(name = "location_y"))
	})
	private Location location;
	private Integer temperature;
	
	@Enumerated(EnumType.STRING)
	private Observatory observatory;
	
	public Weather() {
	}
	
	public Weather(final LocalDateTime timeStamp, final Location location, final Integer temperature, final Observatory observatory) {
		this.timeStamp = timeStamp;
		this.location = location;
		this.temperature = temperature;
		this.observatory = observatory;
	}
	
	public Long getWeatherId() {
		return this.weatherId;
	}
	
	public void setWeatherId(final Long weatherId) {
		this.weatherId = weatherId;
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
