package com.sportradar.valerydauzhuk.betesttask.service;

import com.sportradar.valerydauzhuk.betesttask.helpers.Result;
import com.sportradar.valerydauzhuk.betesttask.models.mainjsonparse.SportEvents;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MostProbableEventsResults {
    SportEvents sportEvents;

    private MostProbableEventsResults() {
        this.sportEvents = JsonToSportEventsParser.parseJsonToSportEventsObject();
    }
    public List<Result> matchResults(int recordsDisplayLimit){

        if(recordsDisplayLimit <= 0 || recordsDisplayLimit > overallEventsNumber()){
            recordsDisplayLimit = overallEventsNumber();
        }

        List<Result> results = new ArrayList<>(recordsDisplayLimit);

        sportEvents.getEvents()
                .stream()
                .limit(recordsDisplayLimit)
                .forEach(e -> results.add(new Result(e.getStartDate().toString(),new StringBuilder().append(e.getCompetitors().get(0).getName())
                        .append("(").append(e.getCompetitors().get(0).getCountry()).append(")").append(" vs. ")
                        .append(e.getCompetitors().get(1).getName()).append("(").append(e.getCompetitors().get(1).getCountry())
                        .append(")").toString(),
                        e.getVenue() == null ? "No Information Provided" : e.getVenue().getName(),
                        CompareProbabilities.compareHomeTeamAwayTeamDrawProbabilities(e.getProbabilityHomeTeamWinner(),
                                e.getProbabilityAwayTeamWinner(), e.getProbabilityDraw()))));
        return results;
    }

    private int overallEventsNumber(){
        return sportEvents.getEvents().size();
    }
}
