package com.codecool.leaguestatistics.view;

import com.codecool.leaguestatistics.model.LeagueStatistics;
import com.codecool.leaguestatistics.model.Team;

import java.util.List;

/**
 * Provides console view
 */
public class Display {
    private static int SIZE = 28;
    private static int SIZELOSSES = 4;
    private static int SIZEPOINTS = 4;
    private static int SIZEWINS = 2;
    private static int SIZDRAWS = 3;
    private static String FILLER = " | ";

    public Display() {
    }

    public static void printTable(List<Team> league) {
        Team longestName = LeagueStatistics.getTeamWithTheLongestName(league);
        int size = longestName.getName().length() + SIZE;
        String printStatement = "|" + "-".repeat(size) + "|\n" + "|" + " ".repeat((int) Math.floor(longestName.getName().length() / 2.0))
                + "TEAM" + " ".repeat((int) (Math.round(longestName.getName().length() / 2.0) - 1))
                + "|POINTS|WINS|DRAWS|LOSSES|";
        System.out.println(printStatement);
        System.out.println("|" + "-".repeat(size) + "|");
        for (Team team : league) {
            System.out.print("| ");
            System.out.print(team.getName());
            System.out.println(" ".repeat(longestName.getName().length() - team.getName().length()) + "  | "
                    + team.getCurrentPoints() + " ".repeat(Math.max(SIZEPOINTS - Integer.toString(team.getCurrentPoints()).length(), 0)) + FILLER
                    + team.getWins() + " ".repeat(Math.max(SIZEWINS - Integer.toString(team.getWins()).length(), 0)) + FILLER
                    + team.getDraws() + " ".repeat(Math.max(SIZDRAWS - Integer.toString(team.getDraws()).length(), 0)) + FILLER
                    + team.getLoses() + " ".repeat(Math.max(SIZELOSSES - Integer.toString(team.getLoses()).length(), 0)) + FILLER);
            System.out.println("|" + "-".repeat(size) + "|");
        }
    }

    public static void printMatchResult(Team team1, Team team2, int scoreTeam1, int scoreTeam2) {
        String message = team1.getName() + " vs " + team2.getName() + " : " + scoreTeam1 + ":" + scoreTeam2;
        System.out.println(message);


    }
}