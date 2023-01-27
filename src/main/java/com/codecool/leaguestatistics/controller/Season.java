package com.codecool.leaguestatistics.controller;

import com.codecool.leaguestatistics.factory.LeagueFactory;
import com.codecool.leaguestatistics.model.Team;
import com.codecool.leaguestatistics.view.Display;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Provides all necessary methods for season simulation
 */
public class Season {

    private List<Team> league;

    public Season() {
        league = new ArrayList<>();
    }


    public void run() {
        this.league = LeagueFactory.createLeague(6);
        playAllGames();
        sortLeagueByPoints();
        Display.printTable(league);
        // Call Display methods below

    }

    /**
     * Playing whole round. Everyone with everyone one time. Number of teams in league should be even.
     * Following solution represents the robin-round tournament.
     */
    private void playAllGames() {
        int count = 0;
        for (int i = 0; i < league.size()-1 ; i++) {
            for (int j = i; j < league.size() ; j++) {
                if (league.get(i) == league.get(j))
                    continue;
                playMatch(league.get(i),league.get(j));
                count++;
            }
        }
        System.out.println("Number of matches: " + count);
    }

    /**
     * Plays single game between two teams and displays result after.
     */
    private void playMatch(Team team1, Team team2) {
        int scoreTeam1 = getScoredGoals(team1);
        int scoreTeam2 = getScoredGoals(team2);
        int result = scoreTeam1 - scoreTeam2 >= 1 ? 1 : (scoreTeam1 == scoreTeam2 ? 0 : -1);
        switch (result) {
            case 0:
                team1.setDraws(team1.getDraws() + 1);
                team2.setDraws(team2.getDraws() + 1);
                break;
            case -1:
                team2.setWins(team2.getWins() + 1);
                team1.setLoses(team1.getLoses() + 1);
                break;
            case 1:
                team1.setWins(team1.getWins() + 1);
                team2.setLoses(team2.getLoses() + 1);
                break;
        }
        Display.printMatchResult(team1, team2, scoreTeam1, scoreTeam2);
    }

    /**
     * Checks for each player of given team chance to score based on skillrate.
     * Adds scored goals to player's and team's statistics.
     *
     * @return All goals scored by the team in current game
     */
    private int getScoredGoals(Team team) {
        int score = team.getPlayers().stream()
                .filter(player -> player.hasScored())
                .mapToInt(player -> player.getGoals())
                .sum();
        team.resetPlayerGoals();
        return score;
    }


    public void sortLeagueByPoints(){
        this.league =  league.stream().sorted((Comparator.comparing(team -> team.getCurrentPoints()))).collect(Collectors.toList());
        Collections.reverse(league);
    }
}
