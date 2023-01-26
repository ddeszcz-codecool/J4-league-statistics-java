package com.codecool.leaguestatistics.model;

import com.codecool.leaguestatistics.factory.NamesGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a team.
 */
public class Team {
    private int ZERO = 0;
    private String name;
    private Division division;
    private int wins;
    private int draws;
    private int loses;
    private List<Player> players;

    public Team(Division division, List<Player> players) {
        this.name = NamesGenerator.getTeamName();
        this.division = division;
        this.players = players;
    }

    public Team() {
    }

    /**
     * Helper method that finds best player with most scored goals in team
     */
    public Player getBestPlayer() {
        List<Player> team = players.stream()
                .sorted(Comparator.comparing(player -> player.getGoals()))
                .collect(Collectors.toList());
        return team.get(team.size()-1);
    }

    /**
     * CurrentPoints is a sum of wins and draws points. For each win 3 points, for draw 1 point.
     */
    public int getCurrentPoints() {
        return (wins * 3 + draws);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return name;
    }

    public void resetPlayerGoals() {
        players.stream().forEach(player -> player.setGoals(ZERO));   // TODO: ask if there is other way | How to call a function ?
    }

}
