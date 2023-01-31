package org.example.division;

import java.util.ArrayDeque;
import java.util.Deque;

public class DivisionService {
    public String getDivision(int dividend, int divider) {
        DivisionService divisionService = new DivisionService();
        DivisionResult divisionResult = divisionService.divide(dividend, divider);
        DivisionFormatter divisionFormatter = new DivisionFormatter(divisionResult);
        return divisionFormatter.format();
    }

    public DivisionResult divide(int dividend, int divider) {
        if (divider == 0) {
            throw new RuntimeException("Division by zero is not possible");
        }
        int result = dividend / divider;
        Deque<Integer> stack = getDivisionQueue(dividend, divider, result);
        return new DivisionResult(dividend, divider, result, stack);
    }

    private Deque<Integer> getDivisionQueue(int dividend, int divider, int result) {
        Deque<Integer> deque = new ArrayDeque<>();
        int remain = dividend % divider;
        if (dividend < divider) {
            deque.push(remain);
            deque.push(result * divider);
            return deque;
        }
        deque.push(remain);
        while (result > 0) {
            int lastDigit = result % 10;
            int multi = lastDigit * divider;
            deque.push(multi);
            deque.push(multi + remain);
            dividend /= 10;
            remain = dividend % divider;
            result /= 10;
        }
        deque.pop();
        return deque;
    }
}
