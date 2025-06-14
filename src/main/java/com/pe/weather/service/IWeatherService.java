package com.pe.weather.service;

import com.pe.weather.model.WeatherResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IWeatherService {

    Mono<WeatherResponse> getWeatherByCity(String city);
    Flux<WeatherResponse> getAll();
}
