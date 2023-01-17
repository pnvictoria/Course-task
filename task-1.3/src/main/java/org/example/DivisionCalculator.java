package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class DivisionCalculator {
    public DivisionResult divide(int dividend, int divider) {
        if (divider == 0){
            throw new NullPointerException("Incorrect divider number");
        }
        int result = dividend / divider;
        Deque<Integer> stack = getDivisionQueue(dividend, divider, result);
        return new DivisionResult(dividend, divider, result, stack);
    }

    protected Deque<Integer> getDivisionQueue(int dividend, int divider, int result) {
        Deque<Integer> stack = new ArrayDeque<>();
        int remain = dividend % divider;
        if (dividend < divider){
            stack.push(remain);
            stack.push(result * divider);
            return stack;
        }
        stack.push(remain);

        while (result > 0) {
            int lastDigit = result % 10;
            int multi = lastDigit * divider;
            stack.push(multi);
            stack.push(multi + remain);
            dividend /= 10;
            remain = dividend % divider;
            result /= 10;
        }
        stack.pop();

        return stack;
    }
}
