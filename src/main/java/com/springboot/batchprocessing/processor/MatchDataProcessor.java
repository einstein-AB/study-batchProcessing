package com.springboot.batchprocessing.processor;

import com.springboot.batchprocessing.modal.Match;
import com.springboot.batchprocessing.modal.MatchInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        match.setNeutralVenue(matchInput.getNeutral_venue());

        /**
         * Sample manipulation operation. Setting team1 as the one who bats first and team2 who chases the target
         * team1: bats firsts
         * team2: bats second
         * */
        String firstInningsTeam;
        String secondInningsTeam;
        if (matchInput.getTeam1().equals(matchInput.getToss_winner())) {
            firstInningsTeam = matchInput.getTeam1();
            secondInningsTeam = matchInput.getTeam2();
        } else {
            firstInningsTeam = matchInput.getTeam2();
            secondInningsTeam = matchInput.getTeam1();
        }
        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        /*---------------------*/

        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setEliminator(matchInput.getEliminator());
        match.setMethod(matchInput.getMethod());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        log.info("Converting MatchInput (CSV Data) into Match (Custom DB specific object)");
        return match;
    }

}
