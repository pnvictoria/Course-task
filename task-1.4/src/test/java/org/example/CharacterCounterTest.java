package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {
    private final String SEPARATOR = System.lineSeparator();
    private final CharacterCounter counter;

    public CharacterCounterTest() {
        counter = new CharacterCounter();
    }

    @Test
    public void computeStatistics_returnSameString_whenInputIsSame() {
        String expected = counter.computeStatistics("hello world!");
        String actual = counter.computeStatistics("hello world!");
        assertEquals(expected, actual);
    }

    @Test
    public void computeStatistics_returnStringWithCountedUniqueCharacters_whenInputIsString() {
        String expected = "\"h\" - 1" + SEPARATOR +
                          "\"e\" - 1" + SEPARATOR +
                          "\"l\" - 3" + SEPARATOR +
                          "\"o\" - 2" + SEPARATOR +
                          "\" \" - 1" + SEPARATOR +
                          "\"w\" - 1" + SEPARATOR +
                          "\"r\" - 1" + SEPARATOR +
                          "\"d\" - 1" + SEPARATOR +
                          "\"!\" - 1" + SEPARATOR;
        String actual = counter.computeStatistics("hello world!");
        assertEquals(expected, actual);
    }

    @Test
    public void computeStatistics_throwException_whenInputIsNull() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> counter.computeStatistics(null));
        assertTrue(exception.getMessage().contains("Input to count should be not null"));
    }
}
