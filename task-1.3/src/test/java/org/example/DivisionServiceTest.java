package org.example;

import org.example.division.DivisionService;
import org.example.division.DivisionResult;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DivisionServiceTest {
    public DivisionService divisionService;

    public DivisionServiceTest() {
        divisionService = new DivisionService();
    }

    @Test
    void divide_getExpectedIntegers_ifInputIsNumbers() {
        int dividend = 10;
        int divider = 20;
        Stack<Integer> expected = new Stack<>();
        expected.add(10);
        expected.add(0);

        DivisionResult actual = divisionService.divide(dividend, divider);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.pop(), actual.getIntermediateResults().pop());
        }
    }

    @Test
    void divide_getExpectedError_ifDividerNumberIsNull() {
        int dividend = 100;
        int divider = 0;

        Exception exception = assertThrows(NullPointerException.class, () -> divisionService.divide(dividend, divider), "Invalid error message.");
        assertEquals("Incorrect divider number", exception.getMessage());
    }
}
