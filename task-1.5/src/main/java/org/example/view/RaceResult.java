package org.example.view;

import org.example.service.RaceService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceResult {
    private static final String SEPARATOR = System.lineSeparator();
    private static final int LINE_INDEX = 14;
    private static final String LINE = "-";
    private static final String JOINER = " | ";

    private final RaceService raceService;

    public RaceResult() {
        this.raceService = new RaceService();
    }

    public String getRaceResult() throws IOException {
        List<String[]> racersResult = new ArrayList<>(raceService.orderRacers());
        int maxNameSize = getMaxNameSize(racersResult).orElse(0);
        int maxTeamSize = getMaxTeamSize(racersResult).orElse(0);
        return racersResult.stream()
                .map(v -> buildRow(v, racersResult.indexOf(v), maxNameSize, maxTeamSize))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String buildRow(String[] races, int index, int maxNameSize, int maxTeamSize) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%2d. %-"+maxNameSize+"s%s%-"+maxTeamSize+"s%s" + races[2],
                index + 1, races[0], JOINER, races[1], JOINER));
        if (index == LINE_INDEX) {
            result.append(SEPARATOR).append(printUnderLine(result.length()));
        }
        return result.toString();
    }

    private String printUnderLine(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> LINE)
                .collect(Collectors.joining());
    }

    private Optional<Integer> getMaxNameSize(List<String[]> racers) {
        return racers.stream()
                .map(v -> v[0].length())
                .max(Integer::compare);
    }

    private Optional<Integer> getMaxTeamSize(List<String[]> racers) {
        return racers.stream()
                .map(v -> v[1].length())
                .max(Integer::compare);
    }
}
