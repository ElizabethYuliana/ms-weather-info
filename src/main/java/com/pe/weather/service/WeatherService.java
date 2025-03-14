package com.pe.weather.service;

import com.pe.weather.entity.Weather;
import com.pe.weather.model.WeatherResponse;
import com.pe.weather.repository.IWeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherService implements IWeatherService {
    private final IWeatherRepository weatherRepository;

    @Override
    public Mono<WeatherResponse> getWeatherByCity(String city) {
        return weatherRepository.findByCity(city)
                .map(this::buildWeatherResponse);
    }

    @Override
    public Flux<WeatherResponse> getAll() {
        return weatherRepository.findAll().map(this::buildWeatherResponse);
    }

    private WeatherResponse buildWeatherResponse(Weather weather) {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(weather.getCity());
        weatherResponse.setCountry(weather.getCountry());
        weatherResponse.setWeather(weather.getCondition());
        weatherResponse.setTemperature(weather.getTemperature());
        weatherResponse.setHumidity(weather.getHumidity());
        weatherResponse.setWind(weather.getWind());
        return weatherResponse;
    }
}
