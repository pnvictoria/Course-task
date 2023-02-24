package org.example.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateService {
    private static final String DATA_PATTERN_PARSER = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static final String RACE_TIME_PATTERN_PARSER = "mm:ss.SSS";

    public LocalDateTime dateParser(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATA_PATTERN_PARSER));
    }

    public LocalDateTime calculateTime(LocalDateTime start, LocalDateTime end) {
        return end.minusHours(start.getHour())
                .minusMinutes(start.getMinute())
                .minusSeconds(start.getSecond())
                .minusNanos(start.getNano());
    }

    public String getRaceTime(LocalDateTime duration) {
        return duration.format(DateTimeFormatter.ofPattern(RACE_TIME_PATTERN_PARSER));
    }
}
