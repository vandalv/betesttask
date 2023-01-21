package com.sportradar.valerydauzhuk.betesttask.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportradar.valerydauzhuk.betesttask.models.mainjsonparse.SportEvents;

import java.io.File;
import java.io.IOException;

public final class JsonToSportEventsParser {

    private JsonToSportEventsParser() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static SportEvents parseJsonToSportEventsObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("data/BE_data.json"), SportEvents.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
