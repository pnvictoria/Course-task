package org.example.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParseRaceService {
    private static final String DATA_PATTERN_PARSER = "yyyy-MM-dd_HH:mm:ss.SSS";

    public Map<String, LocalDateTime> getAbbreviationsAndTime(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> list.get(i).substring(0, 3),
                        i -> parseDate(list.get(i).substring(3)),
                        (a, b) -> b,
                        HashMap::new
                ));
    }

    public Map<String, String[]> getAbbreviationsAndRacer(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> list.get(i).substring(0, 3),
                        i -> list.get(i).substring(4).split("_"),
                        (a, b) -> b,
                        HashMap::new
                ));
    }

    private LocalDateTime parseDate(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATA_PATTERN_PARSER));
    }
}
