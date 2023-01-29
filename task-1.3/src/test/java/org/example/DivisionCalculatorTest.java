package org.example;

import org.example.division.DivisionCalculator;
import org.example.division.DivisionResult;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DivisionCalculatorTest {
    public DivisionCalculator divisionCalculator;

    public DivisionCalculatorTest() {
        divisionCalculator = new DivisionCalculator();
    }

    @Test
    void getDivisionQueue_getExpectedIntegers_ifInputIsNumbers() {
        Stack<Integer> expected = new Stack<>();
        int[] arr = {1, 24, 25, 12, 14, 28, 29, 36, 38, 4};
        for (int value : arr) {
            expected.add(value);
        }
        Deque<Integer> actual= divisionCalculator.getDivisionQueue(78945, 4, 19736);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.pop(), actual.pop());
        }
    }

    @Test
    void divide_getExpectedIntegers_ifInputIsNumbers() {
        int dividend = 10;
        int divider = 20;
        Stack<Integer> expected = new Stack<>();
        expected.add(10);
        expected.add(0);

        DivisionResult actual = divisionCalculator.divide(dividend, divider);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.pop(), actual.getIntermediateResults().pop());
        }
    }

    @Test
    void divide_getExpectedError_ifDividerNumberIsNull() {
        int dividend = 100;
        int divider = 0;

        Exception exception = assertThrows(NullPointerException.class, () -> divisionCalculator.divide(dividend, divider), "Invalid error message.");
        assertEquals("Incorrect divider number", exception.getMessage());
    }
}
