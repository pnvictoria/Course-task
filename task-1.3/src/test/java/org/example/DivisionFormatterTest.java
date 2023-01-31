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

        String expected =
                "_78|4" + System.lineSeparator() +
                " 4 |--" + System.lineSeparator() +
                " - |19" + System.lineSeparator() +
                "_38" + System.lineSeparator() +
                " 36" + System.lineSeparator() +
                " --" + System.lineSeparator() +
                "  2";
        formatter.setDivisionResult(divisionResult);
        String actual = formatter.format();
        assertEquals(expected, actual);
    }

    @Test
    void format_getPeekOfNull_ifIntermediateResultsIsEmpty() {
        DivisionResult divisionResult = new DivisionResult(78, 4, 19, new ArrayDeque<>());
        formatter.setDivisionResult(divisionResult);
        Exception ex = assertThrows(RuntimeException.class, () -> formatter.format(), "Division by zero is not possible");
        assertEquals("List is empty!", ex.getMessage());
    }
}
