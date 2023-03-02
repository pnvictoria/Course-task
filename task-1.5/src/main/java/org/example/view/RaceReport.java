package org.example.view;

import org.example.model.ReportLine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RaceReport {
    private static final DateTimeFormatter RACE_TIME_PATTERN_FORMATTER = DateTimeFormatter.ofPattern("mm:ss.SSS");
    private static final String SEPARATOR = System.lineSeparator();
    private static final int LINE_INDEX = 14;
    private static final String LINE = "-";
    private static final String JOINER = " | ";

    public String getRaceReport(List<ReportLine> racersResult) {
        int maxNameSize = getMaxNameSize(racersResult).orElse(0);
        int maxTeamSize = getMaxTeamSize(racersResult).orElse(0);
        return racersResult.stream()
                .map(v -> buildRow(v, racersResult.indexOf(v), maxNameSize, maxTeamSize))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String buildRow(ReportLine races, int index, int maxNameSize, int maxTeamSize) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%2d. %-"+maxNameSize+"s%s%-"+maxTeamSize+"s%s" + getRaceTime(races.getDuration()),
                index + 1, races.getRacer(), JOINER, races.getTeam(), JOINER));
        if (index == LINE_INDEX) {
            result.append(SEPARATOR).append(LINE.repeat((result.length())));
        }
        return result.toString();
    }

    private Optional<Integer> getMaxNameSize(List<ReportLine> racers) {
        return racers.stream()
                .map(v -> v.getRacer().length())
                .max(Integer::compare);
    }

    private Optional<Integer> getMaxTeamSize(List<ReportLine> racers) {
        return racers.stream()
                .map(v -> v.getTeam().length())
                .max(Integer::compare);
    }

    private String getRaceTime(LocalDateTime duration) {
        return duration.format(RACE_TIME_PATTERN_FORMATTER);
    }
}
