package test.task.baloon.consumer.weather;

import org.springframework.data.repository.CrudRepository;

import test.task.baloon.consumer.weather.model.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
}
