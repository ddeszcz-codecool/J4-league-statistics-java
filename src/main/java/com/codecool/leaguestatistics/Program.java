package com.codecool.leaguestatistics;

import com.codecool.leaguestatistics.controller.Season;
import com.codecool.leaguestatistics.factory.NamesGenerator;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Program {

    public static void main( String[] args ) throws FileNotFoundException {
        Season season = new Season();
        season.run();
    }
}
