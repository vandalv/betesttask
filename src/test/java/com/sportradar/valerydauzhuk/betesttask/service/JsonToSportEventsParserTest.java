package com.sportradar.valerydauzhuk.betesttask.service;

import com.sportradar.valerydauzhuk.betesttask.models.mainjsonparse.SportEvents;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class JsonToSportEventsParserTest {

    SportEvents sportEvents;

    @Before
    public void init() {
        this.sportEvents = JsonToSportEventsParser.parseJsonToSportEventsObject();
    }

    @Test
    public void numberOfMatchesCheck() {
        int numberOfMatchesParsed = sportEvents.getEvents().size();
        assertEquals(73, numberOfMatchesParsed);
    }
}