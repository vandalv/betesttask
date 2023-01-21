package com.sportradar.valerydauzhuk.betesttask.service;

import com.sportradar.valerydauzhuk.betesttask.enums.MatchResult;
import java.util.Arrays;
import java.util.Collections;

public class CompareProbabilities {

    private CompareProbabilities() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    public static String compareHomeTeamAwayTeamDrawProbabilities(double homeTeamWinner, double awayTeamWinner, double draw){

        StringBuilder winnerPrediction = new StringBuilder();

        double maxProbability = Collections.max(Arrays.asList(homeTeamWinner, awayTeamWinner, draw));

        if(homeTeamWinner == maxProbability){
            winnerPrediction.append(MatchResult.HOME_TEAM_WIN);
        } else if(awayTeamWinner == maxProbability){
            winnerPrediction.append(MatchResult.AWAY_TEAM_WIN);
        } else {
            winnerPrediction.append(MatchResult.DRAW);
        }
        return winnerPrediction.append("(").append(maxProbability).append(")").toString();
    }
}
