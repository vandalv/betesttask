package com.sportradar.valerydauzhuk.betesttask.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    String startDate;
    String competitors;
    String venue;
    String highestProbableResult;

    public Result(String startDate, String competitors, String venue, String highestProbableResult) {
        this.startDate = startDate;
        this.competitors = competitors;
        this.venue = venue;
        this.highestProbableResult = highestProbableResult;
    }

    @Override
    public String toString() {
        return "Start date: " + this.startDate + "," + System.lineSeparator() +
                this.competitors + System.lineSeparator() +
                "Venue: " + this.venue + System.lineSeparator() +
                "Highest probable result: " + this.highestProbableResult + System.lineSeparator();
    }
}
