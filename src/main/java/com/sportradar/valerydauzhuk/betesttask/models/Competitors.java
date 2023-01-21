package com.sportradar.valerydauzhuk.betesttask.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Competitors {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("country")
    String country;

    @JsonProperty("country_code")
    String countryCode;

    @JsonProperty("abbreviation")
    String abbreviation;

    @JsonProperty("qualifier")
    String qualifier;

    @JsonProperty("gender")
    String gender;
}
