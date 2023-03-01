package org.example;

import org.example.model.Race;
import org.example.service.FileService;
import org.example.service.ParseRaceService;
import org.example.service.RaceService;
import org.example.view.RaceReport;

import java.io.IOException;
import java.util.List;

public class App {
    public static final String START_FILE = "task-1.5/src/main/resources/start.log";
    public static final String END_FILE = "task-1.5/src/main/resources/end.log";
    public static final String ABBREVIATIONS_FILE = "task-1.5/src/main/resources/abbreviations.txt";

    public static void main(String[] args) throws IOException {
        RaceService raceService = new RaceService();
        ParseRaceService parseRaceService = new ParseRaceService();
        FileService fileService = new FileService();
        List<Race> races = raceService.orderRacers(parseRaceService.getAbbreviationsAndRacer(fileService.read(ABBREVIATIONS_FILE)),
                parseRaceService.getAbbreviationsAndTime(fileService.read(START_FILE)),
                parseRaceService.getAbbreviationsAndTime(fileService.read(END_FILE)));

        RaceReport raceReport = new RaceReport();
        System.out.println(raceReport.getRaceReport(races));
    }
}
