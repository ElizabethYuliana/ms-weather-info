package com.pe.weather.repository;

import com.pe.weather.entity.Weather;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IWeatherRepository extends ReactiveMongoRepository<Weather, String>{

    Mono<Weather> findByCity(String city);

}
