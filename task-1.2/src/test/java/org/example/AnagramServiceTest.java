package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramServiceTest extends TestCase {

    public AnagramService anagramService;

    public AnagramServiceTest() {
        anagramService = new AnagramService();
    }

    @Test
    public void reverseWords_returnEmptyString_ifInputIsNull() {
        Assertions.assertEquals( "", anagramService.reverseWords(null));
    }

    @Test
    public void reverseWords_shouldReturnEmptyString_whenInputStringContainsOneSpace() {
        Assertions.assertEquals( "", anagramService.reverseWords(" "));
    }

    @Test
    public void reverseWords_shouldReturnEmptyString_whenInputStringContainsEmptyString() {
        Assertions.assertEquals( "", anagramService.reverseWords(new String()));
    }

    @Test
    public void reverseWords_shouldReturnEmptyString_whenInputStringContainsSpaces() {
        Assertions.assertEquals( "", anagramService.reverseWords("   "));
    }

    @Test
    public void reverseWords_shouldReturnReverseWord_whenInputStringContainsWord() {
        Assertions.assertEquals( "dcba", anagramService.reverseWords("abcd"));
    }

    @Test
    public void reverseWords_returnReverseWords_ifInputContainsWordsWithCapitalLetter() {
        Assertions.assertEquals( "Dcba hgFe", anagramService.reverseWords("abcD eFgh"));
    }

    @Test
    public void reverseWords_shouldReturnReverseWord_whenInputStringContainsSomeWordsWithSymbols() {
        Assertions.assertEquals( "123hgfe", anagramService.reverseWords("123efgh"));
    }

    @Test
    public void reverseWords_shouldReturnSame_whenInputStringContainsOnlySymbols() {
        Assertions.assertEquals( "!123", anagramService.reverseWords("!123"));
    }
}
