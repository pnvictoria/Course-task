package org.example;

import org.example.view.RaceResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceResultTest {
    private static final String SEPARATOR = System.lineSeparator();
    private RaceResult raceResult;

    @BeforeEach
    void setup() {
        raceResult = new RaceResult();
    }

    @Test
    public void getRaceResult_returnStringWithCountedUniqueCharacters_whenInputIsSpaces() throws IOException {
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
        String actual = raceResult.getRaceResult();
        assertEquals(expected, actual);
    }
}
