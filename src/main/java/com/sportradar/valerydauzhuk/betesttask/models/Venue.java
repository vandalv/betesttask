package com.sportradar.valerydauzhuk.betesttask.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venue {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("capacity")
    int capacity;

    @JsonProperty("city_name")
    String cityName;

    @JsonProperty("country_name")
    String countryName;

    @JsonProperty("map_coordinates")
    String mapCoordinates;

    @JsonProperty("country_code")
    String countryCode;
}
