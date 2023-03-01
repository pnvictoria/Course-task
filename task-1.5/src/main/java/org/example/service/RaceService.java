package org.example.service;

import org.example.model.Race;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class RaceService {
    public List<Race> orderRacers(Map<String, String[]> racers, Map<String, LocalDateTime> startFileData, Map<String, LocalDateTime> endFileData) {
        LinkedHashMap<String, LocalDateTime> sorted = new LinkedHashMap<>(sortGroupRaces(startFileData, endFileData));
        return sorted.keySet().stream()
                .filter(racers::containsKey)
                .map(key -> new Race(racers.get(key)[0], racers.get(key)[1], sorted.get(key)))
                .collect(Collectors.toList());
    }

    private Map<String, LocalDateTime> sortGroupRaces(Map<String, LocalDateTime> startFileData, Map<String, LocalDateTime> endFileData) {
        return groupRace(startFileData, endFileData).entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    private Map<String, LocalDateTime> groupRace(Map<String, LocalDateTime> startFileData, Map<String, LocalDateTime> endFileData) {
        return startFileData.entrySet().stream()
                .filter(entry -> endFileData.containsKey(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> calculateTime(entry.getValue(), endFileData.get(entry.getKey()))));
    }

    private LocalDateTime calculateTime(LocalDateTime start, LocalDateTime end) {
        return end.minusHours(start.getHour())
                .minusMinutes(start.getMinute())
                .minusSeconds(start.getSecond())
                .minusNanos(start.getNano());
    }
}
