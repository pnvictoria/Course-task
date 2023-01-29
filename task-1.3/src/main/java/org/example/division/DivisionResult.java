package org.example.division;

import java.util.Deque;

public final class DivisionResult {
    private final int dividend;
    private final int divider;
    private final int result;
    private final Deque<Integer> intermediateResults;

    public DivisionResult(int dividend, int divider, int result, Deque<Integer> stack) {
        this.dividend = dividend;
        this.divider = divider;
        this.result = result;
        this.intermediateResults = stack;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getResult() {
        return result;
    }

    public Deque<Integer> getIntermediateResults() {
        return intermediateResults;
    }
}
