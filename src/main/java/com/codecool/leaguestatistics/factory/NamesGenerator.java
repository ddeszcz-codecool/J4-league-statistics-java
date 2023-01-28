package com.codecool.leaguestatistics.factory;

import com.codecool.leaguestatistics.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Provides random names for Players and Teams
 */
public class NamesGenerator {

    public static String getPlayerName() {
        return getRandomStringFromFile("PlayerNames.txt");
    }

    public static String getTeamName() {
        return getRandomStringFromFile("CityNames.txt") + " " + getRandomStringFromFile("TeamNames.txt");
    }




    private static String getRandomStringFromFile(String fileName) {
        String str = "";
        List<String> fileLines = new ArrayList<>();
        String filePath = fileName;
        try{
            URL url = NamesGenerator.class.getClassLoader().getResource(filePath);
            File myObj = new File(url.getPath());
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                fileLines.add(data);

            }
            str = fileLines.get(new Random().nextInt(fileLines.size()));

            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred. File not found");
            e.printStackTrace();
        }
        return str;

    }


}
