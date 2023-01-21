package com.sportradar.valerydauzhuk.betesttask.controllers;

import com.sportradar.valerydauzhuk.betesttask.helpers.Result;
import com.sportradar.valerydauzhuk.betesttask.service.CompetitorsNamesSortedAlphabetically;
import com.sportradar.valerydauzhuk.betesttask.service.MostProbableEventsResults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
public class FeaturesController {

    CompetitorsNamesSortedAlphabetically competitorsNamesSortedAlphabetically;
    MostProbableEventsResults mostProbableEventsResults;

    public FeaturesController(CompetitorsNamesSortedAlphabetically competitorsNamesSortedAlphabetically, MostProbableEventsResults mostProbableEventsResults) {
        this.competitorsNamesSortedAlphabetically = competitorsNamesSortedAlphabetically;
        this.mostProbableEventsResults = mostProbableEventsResults;
    }

    @GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Result> results(@RequestParam(required = false, defaultValue="0") int limit){
        return mostProbableEventsResults.matchResults(limit);
    }

    @GetMapping(value = "/unique-competitors-names", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> uniqueCompetitorNames(){
        competitorsNamesSortedAlphabetically.allUniqueCompetitorNames();
        return competitorsNamesSortedAlphabetically.getCompetitorsNames();
    }

    @GetMapping(value = "/{competition}/unique-competitors-names", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> uniqueCompetitorNamesForGivenCompetition(@PathVariable final String competition){
        competitorsNamesSortedAlphabetically.setCompetitorsNames(new TreeSet<>());
        competitorsNamesSortedAlphabetically.allUniqueCompetitorNamesForGivenCompetition(competition);
        return competitorsNamesSortedAlphabetically.getCompetitorsNames();
    }
}
