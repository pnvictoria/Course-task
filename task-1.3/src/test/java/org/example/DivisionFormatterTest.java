package org.example;

import org.example.division.DivisionFormatter;
import org.example.division.DivisionResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionFormatterTest {
    public DivisionFormatter formatter;

    public DivisionFormatterTest() {
        formatter = new DivisionFormatter();
    }
    @Test
    void format_getFormatString_ifInputIsNumbers() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(36);
        stack.push(38);
        stack.push(4);
        DivisionResult divisionResult = new DivisionResult(78, 4, 19, stack);

        String expected = "_78|4\n" + " 4 |--\n" + " - |19\n" + "_38\n" + " 36\n" + " --\n" + "  2";
        String actual = formatter.format(divisionResult);
        assertEquals(expected, actual);
    }

    @Test
    void repeatSymbol_getStringWithRepeatSymbol_ifInputIsStringAndCount() {
        String actual = formatter.repeatSymbol(3, "Hello!");
        String expected = "Hello!Hello!Hello!";
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfDigits_ifInputIsLongInteger() {
        int actual = formatter.getCountOfDigits(123456789);
        assertEquals(9, actual);
    }

    @Test
    void getCountOfDigits_ifInputIsShortInteger() {
        int actual = formatter.getCountOfDigits(0);
        assertEquals(1, actual);
    }

    @Test
    void format_getPeekOfNull_ifIntermediateResultsIsEmpty() {
        DivisionResult divisionResult = new DivisionResult(78, 4, 19, new ArrayDeque<>());
        Exception ex = assertThrows(NullPointerException.class, () -> formatter.format(divisionResult), "Invalid error message.");
        assertEquals("List is empty!", ex.getMessage());
    }
}
