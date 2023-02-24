package org.example.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class RaceService {
    private static final String START_PATH = "start.log";
    private static final String END_PATH = "end.log";
    private static final String ABBREVIATIONS_PATH = "abbreviations.txt";

    private final DateService dateService;
    private final FileService fileService;

    public RaceService() {
        this.dateService = new DateService();
        this.fileService = new FileService();
    }

    public List<String[]> orderRacers() throws IOException {
        LinkedHashMap<String, LocalDateTime> sorted = new LinkedHashMap<>(sortGroupRaces());
        Map<String, String[]> racers = getAbbreviationsAndRacer(fileService.read(ABBREVIATIONS_PATH));
        return sorted.keySet().stream()
                .filter(racers::containsKey)
                .map(key -> new String[]{racers.get(key)[0], racers.get(key)[1], dateService.getRaceTime(sorted.get(key))})
                .collect(Collectors.toList());
    }

    private Map<String, LocalDateTime> sortGroupRaces() throws IOException {
        return groupRace().entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    private Map<String, LocalDateTime> groupRace() {
        Map<String, LocalDateTime> startFileData = getAbbreviationsAndTime(fileService.read(START_PATH));
        Map<String, LocalDateTime> endFileData = getAbbreviationsAndTime(fileService.read(END_PATH));
        return startFileData.entrySet().stream()
                .filter(entry -> endFileData.containsKey(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> dateService.calculateTime(entry.getValue(), endFileData.get(entry.getKey()))));
    }

    private Map<String, LocalDateTime> getAbbreviationsAndTime(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> list.get(i).substring(0, 3),
                        i -> dateService.dateParser(list.get(i).substring(3)),
                        (a, b) -> b,
                        HashMap::new
                ));
    }

    private Map<String, String[]> getAbbreviationsAndRacer(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> list.get(i).substring(0, 3),
                        i -> list.get(i).substring(4).split("_"),
                        (a, b) -> b,
                        HashMap::new
                ));
    }
}
