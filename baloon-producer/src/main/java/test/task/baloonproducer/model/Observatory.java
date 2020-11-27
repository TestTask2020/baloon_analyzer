package test.task.baloonproducer.model;

public enum Observatory {
	AU(TemperatureUnit.CELCIUS, DistanceUnit.KM),
	US(TemperatureUnit.FAHRENHEIT, DistanceUnit.MILES),
	FR(TemperatureUnit.KELVIN, DistanceUnit.M);
	
	private TemperatureUnit temperatureUnit;
	private DistanceUnit distanceUnit;
	
	Observatory(TemperatureUnit temperatureUnit, DistanceUnit distanceUnit) {
		this.temperatureUnit = temperatureUnit;
		this.distanceUnit = distanceUnit;
	}
	
	
}
