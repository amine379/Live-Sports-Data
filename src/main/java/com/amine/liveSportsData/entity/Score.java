package com.amine.liveSportsData.entity;

import java.time.LocalDateTime;

//Class Represente Real Time Score Update
public class Score {
    private long scoreId;
    private long matchId ;
    private Team team;
    private int score;
    private LocalDateTime timestamp;
    private String event;

}
