package com.sportradar.valerydauzhuk.betesttask.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
public class SportEvents {

    @JsonProperty("Events")
    List<Events> events;
}
