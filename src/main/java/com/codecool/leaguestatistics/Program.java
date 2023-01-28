package com.codecool.leaguestatistics;

import com.codecool.leaguestatistics.controller.Season;



import java.io.FileNotFoundException;



public class Program {

    public static void main( String[] args ) throws FileNotFoundException {
        Season season = new Season();
        season.run();
    }
}
