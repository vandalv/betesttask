package com.sportradar.valerydauzhuk.betesttask.handlers;

import com.sportradar.valerydauzhuk.betesttask.service.CompetitorsNamesSortedAlphabetically;
import com.sportradar.valerydauzhuk.betesttask.service.MostProbableEventsResults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleOutput implements CommandLineRunner {
    MostProbableEventsResults mostProbableEventsResults;
    CompetitorsNamesSortedAlphabetically competitorsNamesSortedAlphabetically;

    public ConsoleOutput(MostProbableEventsResults mostProbableEventsResults, CompetitorsNamesSortedAlphabetically competitorsNamesSortedAlphabetically) {
        this.mostProbableEventsResults = mostProbableEventsResults;
        this.competitorsNamesSortedAlphabetically = competitorsNamesSortedAlphabetically;
    }

    @Override
    public void run(String... args){
        System.out.println(System.lineSeparator() + "\u001B[32m" + "Most Probable 10 Matches Results: " + "\u001B[0m" + System.lineSeparator());
        mostProbableEventsResults.matchResults(10).forEach(System.out::println);
        System.out.println("\u001B[32m" + "All Team Names For Given Competition Alphabetically: " + "\u001B[0m" + System.lineSeparator());
        competitorsNamesSortedAlphabetically.allUniqueCompetitorNamesForGivenCompetition("UEFA Champions League");
        competitorsNamesSortedAlphabetically.getCompetitorsNames().forEach(System.out::println);
    }
}
