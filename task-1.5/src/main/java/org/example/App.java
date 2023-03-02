package org.example;

import org.example.model.ReportLine;
import org.example.service.FileService;
import org.example.service.ParseRaceService;
import org.example.service.RaceService;
import org.example.view.RaceReport;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class App {
    public static final String START_FILE = "task-1.5/src/main/resources/start.log";
    public static final String END_FILE = "task-1.5/src/main/resources/end.log";
    public static final String ABBREVIATIONS_FILE = "task-1.5/src/main/resources/abbreviations.txt";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<String> abbreviationFileData = fileService.read(ABBREVIATIONS_FILE);
        List<String> startFileData = fileService.read(START_FILE);
        List<String> endFileData = fileService.read(END_FILE);

        ParseRaceService parseRaceService = new ParseRaceService();
        Map<String, ReportLine> reportLine = parseRaceService.getAbbreviationsAndRacer(abbreviationFileData);
        Map<String, LocalDateTime> startData = parseRaceService.getAbbreviationsAndTime(startFileData);
        Map<String, LocalDateTime> endData = parseRaceService.getAbbreviationsAndTime(endFileData);

        RaceService raceService = new RaceService(reportLine, startData, endData);
        List<ReportLine> reportLines = raceService.orderRacers();

        RaceReport raceReport = new RaceReport();
        System.out.println(raceReport.getRaceReport(reportLines));
    }
}
