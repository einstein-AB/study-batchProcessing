package com.springboot.batchprocessing.modal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Match {

    @Id
    private long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String neutralVenue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String winner;
    private String result;
    private String resultMargin;
    private String eliminator;
    private String method;
    private String umpire1;
    private String umpire2;
}
