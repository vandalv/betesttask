package com.sportradar.valerydauzhuk.betesttask.models.mainjsonparse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Events {

    @JsonProperty("sport_event_id")
    String sportEventId;

    @JsonProperty("start_date")
    Date startDate;

    @JsonProperty("sport_name")
    String sportName;

    @JsonProperty("competition_name")
    String competitionName;

    @JsonProperty("competition_id")
    String competitionId;

    @JsonProperty("season_name")
    String seasonName;

    @JsonProperty("competitors")
    List<Competitors> competitors;

    @JsonProperty("venue")
    Venue venue;

    @JsonProperty("probability_home_team_winner")
    double probabilityHomeTeamWinner;

    @JsonProperty("probability_draw")
    double probabilityDraw;

    @JsonProperty("probability_away_team_winner")
    double probabilityAwayTeamWinner;
}
