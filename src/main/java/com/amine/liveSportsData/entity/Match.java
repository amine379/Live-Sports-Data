package com.amine.liveSportsData.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Match {
    private long matchId;
    private Team teamA;
    private Team teamB;
    private LocalDateTime startTime;
    private MatchStatus  status;
    private int scoreA;
    private int scoreB;
    private String location;

}
