package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    DivisionCalculator divisionCalculator = new DivisionCalculator();

    @Test
    void getDivisionListTestOne() {
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
    void getDivisionListTestTwo() {
        Stack<Integer> expected = new Stack<>();
        int[] array = {15, 207, 222, 161, 183, 46};
        for (int value : array) {
            expected.add(value);
        }
        Deque<Integer> actual= divisionCalculator.getDivisionQueue(6432, 23, 279);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.pop(), actual.pop());
        }
    }

    @Test
    void dividendLessThanDividerTest() {
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
    void gettingResultTest() {
        int dividend = 194320;
        int divider = 467;

        int actual = divisionCalculator.divide(dividend, divider).getResult();
        int expected = dividend / divider;

        assertEquals(expected, actual);
    }
}
