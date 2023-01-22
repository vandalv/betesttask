package com.sportradar.valerydauzhuk.betesttask.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class CompetitorsNamesSortedAlphabeticallyTest {

    CompetitorsNamesSortedAlphabetically competitorsNamesSortedAlphabetically;

    @Before
    public void init() {
        this.competitorsNamesSortedAlphabetically = new CompetitorsNamesSortedAlphabetically();
    }

    @Test
    public void checkNumberOffAllUniqueCompetitorNames() {
        competitorsNamesSortedAlphabetically.allUniqueCompetitorNames();
        assertEquals(52, this.competitorsNamesSortedAlphabetically.getCompetitorsNames().size());
    }

    @Test
    public void checkAllUniqueCompetitorNamesForGivenCompetitionWhenCompetitionExists() {
        competitorsNamesSortedAlphabetically.setCompetitorsNames(new TreeSet<>());
        competitorsNamesSortedAlphabetically.allUniqueCompetitorNamesForGivenCompetition("UEFA Champions League");
        assertEquals(52, this.competitorsNamesSortedAlphabetically.getCompetitorsNames().size());
    }

    @Test
    public void checkAllUniqueCompetitorNamesForGivenCompetitionWhenCompetitionDoesntExists() {
        competitorsNamesSortedAlphabetically.setCompetitorsNames(new TreeSet<>());
        competitorsNamesSortedAlphabetically.allUniqueCompetitorNamesForGivenCompetition("World Cup");
        assertTrue(this.competitorsNamesSortedAlphabetically.getCompetitorsNames().size() == 1
                && this.competitorsNamesSortedAlphabetically.getCompetitorsNames().contains("No Results Found"));
    }
}