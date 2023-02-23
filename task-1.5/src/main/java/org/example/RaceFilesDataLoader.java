package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class RaceFilesDataLoader {
    private static final String RESOURCES_PATH = "C:\\Own\\Course-task\\task-1.5\\src\\main\\resources\\";
    private static final String START_PATH = RESOURCES_PATH + "start.log";
    private static final String END_PATH = RESOURCES_PATH + "end.log";
    private static final String ABBREVIATIONS_PATH = RESOURCES_PATH + "abbreviations.txt";
    private static final String SEPARATOR = System.lineSeparator();

    public String orderRacers() {
        LinkedHashMap<String, LocalDateTime> sorted = new LinkedHashMap<>(sortGroupRaces());
        Map<String, String[]> racers = getAbbreviationsAndRacer(read(ABBREVIATIONS_PATH));
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (String key : sorted.keySet()) {
            if (racers.containsKey(key)) {
                result.append(String.format("%s. %s | %s | %s%s",
                        count,
                        racers.get(key)[0],
                        racers.get(key)[1],
                        getRaceTime(sorted.get(key)),
                        SEPARATOR));
                count++;
            }
            if (count == 16) {
                result.append("__________________________________________________________").append(SEPARATOR);
            }
        }
        return result.toString();
    }

    private Map<String, LocalDateTime> sortGroupRaces() {
        return groupRace().entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    private Map<String, LocalDateTime> groupRace() {
        Map<String, LocalDateTime> startFileData = getAbbreviationsAndTime(read(START_PATH));
        Map<String, LocalDateTime> endFileData = getAbbreviationsAndTime(read(END_PATH));
        return startFileData.entrySet().stream()
                .filter(entry -> endFileData.containsKey(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> calculateTime(entry.getValue(), endFileData.get(entry.getKey()))));
    }

    private Map<String, LocalDateTime> getAbbreviationsAndTime(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> list.get(i).substring(0, 3),
                        i -> dateParser(list.get(i).substring(3)),
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

    public List<String> read(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.toList());
        } catch (IOException ex) {
            throw new IllegalArgumentException("Error reading file " + path, ex);
        }
    }

    private LocalDateTime dateParser(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS"));
    }

    private LocalDateTime calculateTime(LocalDateTime start, LocalDateTime end) {
        return end.minusHours(start.getHour())
                .minusMinutes(start.getMinute())
                .minusSeconds(start.getSecond())
                .minusNanos(start.getNano());
    }

    private String getRaceTime(LocalDateTime duration) {
        return duration.format(DateTimeFormatter.ofPattern("mm:ss.SSS"));
    }
}
