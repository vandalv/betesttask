package com.sportradar.valerydauzhuk.betesttask.service;

import com.sportradar.valerydauzhuk.betesttask.models.mainjsonparse.SportEvents;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MostProbableEventsResultsTest {

    MostProbableEventsResults mostProbableEventsResults;
    SportEvents sportEvents;

    @Before
    public void init() {
        this.sportEvents = JsonToSportEventsParser.parseJsonToSportEventsObject();
        this.mostProbableEventsResults = new MostProbableEventsResults();
    }

    @Test
    public void shouldReturnThreeMatches() {
        assertEquals(3, this.mostProbableEventsResults.matchResults(3).size());
    }

    @Test
    public void shouldReturnAllMatchesOnInvalidNegativeInput() {
        assertEquals(73, this.mostProbableEventsResults.matchResults(-1).size());
    }

    @Test
    public void shouldReturnAllMatchesOnInputGreaterThanNumberOfAllMatches() {
        assertEquals(73, this.mostProbableEventsResults.matchResults(1000).size());
    }

    @Test
    public void shouldReturnAllMatchesOnZeroAsInput() {
        assertEquals(73, this.mostProbableEventsResults.matchResults(0).size());
    }
}