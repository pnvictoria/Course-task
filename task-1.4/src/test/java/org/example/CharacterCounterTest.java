package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {
    private static final String SEPARATOR = System.lineSeparator();
    private CharacterCounter counter;

    @BeforeEach
    void setup() {
        counter = new CharacterCounter();
    }

    @Test
    public void characterCounting_returnSameString_whenInputIsSame() {
        String expected = counter.countChars("hello world!");
        String actual = counter.countChars("hello world!");
        assertEquals(expected, actual);
    }

    @Test
    public void characterCounting_returnStringWithCountedUniqueCharacters_whenInputIsSpaces() {
        String expected = "\" \" - 5" + SEPARATOR;
        String actual = counter.countChars("     ");
        assertEquals(expected, actual);
    }

    @Test
    public void characterCounting_returnStringWithCountedUniqueCharacters_whenInputIsSpacesAndNumbers() {
        String expected = "\"3\" - 2" + SEPARATOR +
                "\"4\" - 6" + SEPARATOR +
                "\"9\" - 1" + SEPARATOR +
                "\"8\" - 2" + SEPARATOR +
                "\" \" - 3" + SEPARATOR +
                "\"7\" - 2" + SEPARATOR +
                "\"0\" - 1" + SEPARATOR +
                "\"5\" - 1" + SEPARATOR +
                "\"6\" - 1" + SEPARATOR +
                "\"2\" - 2" + SEPARATOR;
        String actual = counter.countChars("3498 474430 485746 22");
        assertEquals(expected, actual);
    }

    @Test
    public void characterCounting_returnStringWithCountedUniqueCharacters_whenInputIsString() {
        String expected = "\"h\" - 1" + SEPARATOR +
                "\"e\" - 1" + SEPARATOR +
                "\"l\" - 3" + SEPARATOR +
                "\"o\" - 2" + SEPARATOR +
                "\" \" - 1" + SEPARATOR +
                "\"w\" - 1" + SEPARATOR +
                "\"r\" - 1" + SEPARATOR +
                "\"d\" - 1" + SEPARATOR +
                "\"!\" - 1" + SEPARATOR;
        String actual = counter.countChars("hello world!");
        assertEquals(expected, actual);
    }

    @Test
    public void characterCounting_returnStringWithCountedUniqueCharacters_whenInputIsStringWithNumbers() {
        String expected = "\"b\" - 1" + SEPARATOR +
                "\"i\" - 2" + SEPARATOR +
                "\"r\" - 1" + SEPARATOR +
                "\"t\" - 1" + SEPARATOR +
                "\"h\" - 1" + SEPARATOR +
                "\"d\" - 2" + SEPARATOR +
                "\"a\" - 3" + SEPARATOR +
                "\"y\" - 3" + SEPARATOR +
                "\" \" - 4" + SEPARATOR +
                "\"s\" - 1" + SEPARATOR +
                "\"0\" - 1" + SEPARATOR +
                "\"2\" - 1" + SEPARATOR +
                "\"M\" - 1" + SEPARATOR;
        String actual = counter.countChars("birthday day is 02 May");
        assertEquals(expected, actual);
    }

    @Test
    public void characterCounting_returnStringWithCountedUniqueCharacters_whenInputIsEmptyString() {
        String expected = "";
        String actual = counter.countChars("");
        assertEquals(expected, actual);
    }
}
