package com.codecool.leaguestatistics.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

//    private static String getRandomStringFromFile(String fileName) {
//        String str = "";
//        ClassLoader classLoader = NamesGenerator.class.getClassLoader();
//        try (Stream<String> stream = Files.lines(Paths.get(classLoader.getResource(fileName).getFile()), StandardCharsets.UTF_8)) {
//            int lineCount = (int) stream.count();
//            int randomNumber = Utils.getRandomValue(1, lineCount);
//            str = Files.readAllLines(Paths.get(classLoader.getResource(fileName).getFile())).get(randomNumber);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        return str;
//    }


    private static String getRandomStringFromFile(String fileName) {
        String str = "";
        List<String> fileLines = new ArrayList<>();

        try{
//            URL url = NamesGenerator.class.getResource(fileName); // todo does not work
            File myObj = new File("C:\\Users\\rgv468\\JavaGitProjects\\1. JAVA\\W4\\2.LS\\src\\main\\resources\\"+fileName);
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
