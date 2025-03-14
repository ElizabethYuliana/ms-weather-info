package com.pe.weather.controller;

import com.pe.weather.model.WeatherResponse;
import com.pe.weather.service.IWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/weather")
@Controller
@RequiredArgsConstructor
public class WeatherController {
    private final IWeatherService weatherService;

    @GetMapping("/city")
    public Mono<ResponseEntity<WeatherResponse>> getWeatherByCity(@RequestParam String city) {
        return weatherService.getWeatherByCity(city).map(w -> ResponseEntity.ok().body(w));
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<WeatherResponse>>> getAll() {
        return Mono.just(ResponseEntity.ok(weatherService.getAll()));
    }
}
