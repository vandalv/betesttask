package com.sportradar.valerydauzhuk.betesttask.service;

import com.sportradar.valerydauzhuk.betesttask.models.mainjsonparse.SportEvents;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Component
public class CompetitorsNamesSortedAlphabetically {
    Set<String> competitorsNames;
    Set<String> competitionsNames;
    static SportEvents sportEvents = JsonToSportEventsParser.parseJsonToSportEventsObject();

    CompetitorsNamesSortedAlphabetically() {
        this.competitorsNames = new TreeSet<>();
        this.competitionsNames = new TreeSet<>();
    }

    public void allUniqueCompetitorNames(){
            sportEvents.getEvents()
                .forEach(e -> {
                    competitorsNames.add(e.getCompetitors().get(0).getName());
                    competitorsNames.add(e.getCompetitors().get(1).getName());
                });
    }

    public void allUniqueCompetitorNamesForGivenCompetition(String competitionName){
        sportEvents.getEvents()
                .stream()
                .filter(e -> e.getCompetitionName().equalsIgnoreCase(competitionName))
                .forEach(e -> {
                    competitorsNames.add(e.getCompetitors().get(0).getName());
                    competitorsNames.add(e.getCompetitors().get(1).getName());
                });
        if(competitorsNames.isEmpty()){
            competitorsNames.add("No Results Found");
        }
    }
}
