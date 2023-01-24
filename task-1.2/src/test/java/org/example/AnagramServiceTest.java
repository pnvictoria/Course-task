package org.example;

import org.junit.*;
import static org.junit.Assert.*;

public class AnagramServiceTest {
    public AnagramService anagramService;

    public AnagramServiceTest() {
        anagramService = new AnagramService();
    }

    @Test
    public void reverseWords_returnEmptyString_ifInputIsNull() {
        assertEquals( "", anagramService.reverseWords(null));
    }

    @Test
    public void reverseWords_shouldReturnEmptyString_whenInputStringContainsOneSpace() {
        assertEquals( "", anagramService.reverseWords(" "));
    }

    @Test
    public void reverseWords_shouldReturnEmptyString_whenInputStringContainsEmptyString() {
        assertEquals( "", anagramService.reverseWords(new String()));
    }

    @Test
    public void reverseWords_shouldReturnEmptyString_whenInputStringContainsSpaces() {
        assertEquals( "", anagramService.reverseWords("   "));
    }

    @Test
    public void reverseWords_shouldReturnReverseWord_whenInputStringContainsWord() {
        assertEquals( "dcba", anagramService.reverseWords("abcd"));
    }

    @Test
    public void reverseWords_returnReverseWords_ifInputContainsWordsWithCapitalLetter() {
        assertEquals( "Dcba hgFe", anagramService.reverseWords("abcD eFgh"));
    }

    @Test
    public void reverseWords_shouldReturnReverseWord_whenInputStringContainsSomeWordsWithSymbols() {
        assertEquals( "123hgfe", anagramService.reverseWords("123efgh"));
    }

    @Test
    public void reverseWords_shouldReturnSame_whenInputStringContainsOnlySymbols() {
        assertEquals( "!123", anagramService.reverseWords("!123"));
    }
}
