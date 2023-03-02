package org.example;

import org.example.model.ReportLine;
import org.example.service.FileService;
import org.example.service.ParseRaceService;
import org.example.service.RaceService;
import org.example.view.RaceReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportLineReportTest {
    private static final String SEPARATOR = System.lineSeparator();
    public static final String START_FILE = "task-1.5/src/test/resources/start.log";
    public static final String END_FILE = "task-1.5/src/test/resources/end.log";
    public static final String ABBREVIATIONS_FILE = "task-1.5/src/test/resources/abbreviations.txt";

    private ParseRaceService parseRaceService ;
    private FileService fileService;
    private RaceReport raceReport;

    @BeforeEach
    void setup() {
        parseRaceService = new ParseRaceService();
        fileService = new FileService();
        raceReport = new RaceReport();
    }

    @Test
    public void getRaceReport_returnStringWithCountedUniqueCharacters_whenInputIsSpaces() throws IOException {
        String expected = " 1. Sebastian Vettel  | FERRARI                   | 01:04.415" + SEPARATOR +
                " 2. Daniel Ricciardo  | RED BULL RACING TAG HEUER | 01:12.013" + SEPARATOR +
                " 3. Valtteri Bottas   | MERCEDES                  | 01:12.434" + SEPARATOR +
                " 4. Lewis Hamilton    | MERCEDES                  | 01:12.460" + SEPARATOR +
                " 5. Stoffel Vandoorne | MCLAREN RENAULT           | 01:12.463" + SEPARATOR +
                " 6. Kimi Raikkonen    | FERRARI                   | 01:12.639" + SEPARATOR +
                " 7. Fernando Alonso   | MCLAREN RENAULT           | 01:12.657" + SEPARATOR +
                " 8. Sergey Sirotkin   | WILLIAMS MERCEDES         | 01:12.706" + SEPARATOR +
                " 9. Charles Leclerc   | SAUBER FERRARI            | 01:12.829" + SEPARATOR +
                "10. Sergio Perez      | FORCE INDIA MERCEDES      | 01:12.848" + SEPARATOR +
                "11. Romain Grosjean   | HAAS FERRARI              | 01:12.930" + SEPARATOR +
                "12. Pierre Gasly      | SCUDERIA TORO ROSSO HONDA | 01:12.941" + SEPARATOR +
                "13. Carlos Sainz      | RENAULT                   | 01:12.950" + SEPARATOR +
                "14. Esteban Ocon      | FORCE INDIA MERCEDES      | 01:13.028" + SEPARATOR +
                "15. Nico Hulkenberg   | RENAULT                   | 01:13.065" + SEPARATOR +
                "---------------------------------------------------------------" + SEPARATOR +
                "16. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 01:13.179" + SEPARATOR +
                "17. Marcus Ericsson   | SAUBER FERRARI            | 01:13.265" + SEPARATOR +
                "18. Lance Stroll      | WILLIAMS MERCEDES         | 01:13.323" + SEPARATOR +
                "19. Kevin Magnussen   | HAAS FERRARI              | 01:13.393";

        List<String> abbreviationFileData = fileService.read(ABBREVIATIONS_FILE);
        List<String> startFileData = fileService.read(START_FILE);
        List<String> endFileData = fileService.read(END_FILE);

        Map<String, ReportLine> reportLine = parseRaceService.getAbbreviationsAndRacer(abbreviationFileData);
        Map<String, LocalDateTime> startData = parseRaceService.getAbbreviationsAndTime(startFileData);
        Map<String, LocalDateTime> endData = parseRaceService.getAbbreviationsAndTime(endFileData);

        RaceService raceService = new RaceService(reportLine, startData, endData);
        List<ReportLine> reportLines = raceService.orderRacers();

        String actual = raceReport.getRaceReport(reportLines);

        assertEquals(expected, actual);
    }
}
