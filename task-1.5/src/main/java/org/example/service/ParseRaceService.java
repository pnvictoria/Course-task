package org.example.service;

import org.example.model.ReportLine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseRaceService {
    private static final DateTimeFormatter DATA_PATTERN_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public Map<String, LocalDateTime> getAbbreviationsAndTime(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        line -> line.substring(0, 3),
                        line -> parseDate(line.substring(3))
                ));
    }

    public Map<String, ReportLine> getAbbreviationsAndRacer(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        line -> line.substring(0, 3),
                        line -> new ReportLine(parse(line)[0], parse(line)[1])
                ));
    }

    private LocalDateTime parseDate(String date) {
        return LocalDateTime.parse(date, DATA_PATTERN_FORMATTER);
    }

    private String[] parse(String line) {
        return line.substring(4).split("_");
    }
}
