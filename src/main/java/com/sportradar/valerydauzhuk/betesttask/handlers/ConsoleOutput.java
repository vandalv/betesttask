package com.sportradar.valerydauzhuk.betesttask.handlers;

import com.sportradar.valerydauzhuk.betesttask.service.MostProbableEventsResults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleOutput implements CommandLineRunner {
    MostProbableEventsResults mostProbableEventsResults;

    public ConsoleOutput(MostProbableEventsResults mostProbableEventsResults) {
        this.mostProbableEventsResults = mostProbableEventsResults;
    }

    @Override
    public void run(String... args){
        System.out.println(System.lineSeparator() + "\u001B[32m" + "Most Probable 10 Matches Results: " + "\u001B[0m" + System.lineSeparator());
        mostProbableEventsResults.matchResults(10).forEach(System.out::println);

    }
}
