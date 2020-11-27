package test.task.baloon.consumer.weather;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import test.task.baloon.consumer.weather.model.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
	List<Weather> findWeatherByTimeStampBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
