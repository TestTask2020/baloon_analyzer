package test.task.baloon.consumer.model;

public enum Observatory {
	AU(TemperatureUnit.CELCIUS, DistanceUnit.KM),
	US(TemperatureUnit.FAHRENHEIT, DistanceUnit.MILES),
	FR(TemperatureUnit.KELVIN, DistanceUnit.M),
	DEFAULT(TemperatureUnit.KELVIN, DistanceUnit.KM);
	
	private TemperatureUnit temperatureUnit;
	private DistanceUnit distanceUnit;
	
	Observatory(TemperatureUnit temperatureUnit, DistanceUnit distanceUnit) {
		this.temperatureUnit = temperatureUnit;
		this.distanceUnit = distanceUnit;
	}
	
	public static Observatory of(String name) {
		for (Observatory observatory: Observatory.values()) {
			if (observatory.name().equals(name)) {
				return observatory;
			}
		}
		return DEFAULT;
	}
	
}
