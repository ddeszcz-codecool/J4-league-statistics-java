package com.codecool.leaguestatistics.factory;

import com.codecool.leaguestatistics.Utils;
import com.codecool.leaguestatistics.model.Division;
import com.codecool.leaguestatistics.model.Player;
import com.codecool.leaguestatistics.model.Team;


import java.util.ArrayList;
import java.util.List;

/**
 * Provides full set of teams with players
 */
public class LeagueFactory {

    /**
     * For each division, creates given amount of teams. Each team gets a newly created collection of players.
     * The amount of players should be taken from Utils.TEAM_SIZE
     * @param teamsInDivision Indicates number of teams are in division
     * @return Full set of teams with players
     */
    public static List<Team> createLeague(int teamsInDivision) {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < teamsInDivision; i++) {
            Team team = new Team(Division.East,getPlayers(Utils.TEAM_SIZE));
            teams.add(team);
        }
        return teams;
    }

    /**
     * Returns a collection with a given amount of newly created players
     */
    private static List<Player> getPlayers(int amount) {
        List<Player> players = new ArrayList<>();
        for (int j = 0; j < amount; j++) {
            Player player = new Player(getPlayerSkillRate());
            players.add(player);
        }
        return  players;
    }

    private static int getPlayerSkillRate() {
        return Utils.getRandomValue(5, 21);
    }
}
