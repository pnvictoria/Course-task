package org.example.service;

import org.example.model.ReportLine;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class RaceService {
    private final Map<String, ReportLine> reportLine;
    private final Map<String, LocalDateTime> startFileData;
    private final Map<String, LocalDateTime> endFileData;

    public RaceService(Map<String, ReportLine> reportLine, Map<String, LocalDateTime> startFileData, Map<String, LocalDateTime> endFileData) {
        this.reportLine = reportLine;
        this.startFileData = startFileData;
        this.endFileData = endFileData;
    }

    public List<ReportLine> orderRacers() {
        LinkedHashMap<String, LocalDateTime> sorted = new LinkedHashMap<>(sortGroupRaces());
        return sorted.keySet().stream()
                .filter(reportLine::containsKey)
                .map(key -> new ReportLine(reportLine.get(key).getRacer(), reportLine.get(key).getTeam(), sorted.get(key)))
                .collect(Collectors.toList());
    }

    private Map<String, LocalDateTime> sortGroupRaces() {
        return groupRace().entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    private Map<String, LocalDateTime> groupRace() {
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
