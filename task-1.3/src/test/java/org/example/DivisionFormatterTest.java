package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionFormatterTest {
    DivisionFormatter formatter = new DivisionFormatter();
    @Test
    void getFormatStringTest() {
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
    void repeatSymbolTest() {
        String actual = formatter.repeatSymbol(3, "Hello!");

        String expected = "Hello!Hello!Hello!";

        assertEquals(expected, actual);
    }

    @Test
    void getCountOfDigitsTest() {
        int actual = formatter.getCountOfDigits(123456789);

        assertEquals(9, actual);
    }

    @Test
    void getCountOfDigitZeroTest() {
        int actual = formatter.getCountOfDigits(0);

        assertEquals(1, actual);
    }

    @Test
    void tryGettingPeekOfNullTest() {
        DivisionResult divisionResult = new DivisionResult(78, 4, 19, new ArrayDeque<>());

        Exception ex = assertThrows(NullPointerException.class, () -> formatter.format(divisionResult), "Invalid error message.");

        assertEquals("List is empty!", ex.getMessage());
    }
}
