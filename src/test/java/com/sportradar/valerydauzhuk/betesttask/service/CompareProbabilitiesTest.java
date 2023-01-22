package com.sportradar.valerydauzhuk.betesttask.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CompareProbabilitiesTest {

    @Test
    public void shouldReturnHomeTeamWin() {
        assertEquals("HOME_TEAM_WIN(60.0)", CompareProbabilities.compareHomeTeamAwayTeamDrawProbabilities(60.0, 20.0, 20.0)
                );
    }

    @Test
    public void shouldReturnAwayTeamWin() {
        assertEquals("AWAY_TEAM_WIN(70.0)", CompareProbabilities.compareHomeTeamAwayTeamDrawProbabilities(10.0, 70.0, 20.0)
                );
    }

    @Test
    public void shouldReturnDraw() {
        assertEquals("DRAW(50.0)", CompareProbabilities.compareHomeTeamAwayTeamDrawProbabilities(10.0, 40.0, 50.0)
                );
    }
}