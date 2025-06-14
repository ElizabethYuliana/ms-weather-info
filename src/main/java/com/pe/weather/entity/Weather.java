package com.pe.weather.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "weather")
public class Weather {
    @Id
    private String id;//ObjectId
    @Field
    private String city;
    @Field
    private String country;
    @Field
    private String temperature;
    @Field
    private String humidity;
    @Field
    private String wind;
    @Field
    private String condition;

}
