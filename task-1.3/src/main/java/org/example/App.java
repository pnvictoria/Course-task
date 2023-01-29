package org.example;

import org.example.division.DivisionCalculator;
import org.example.division.DivisionFormatter;
import org.example.division.DivisionResult;

public class App {
    public static void main(String[] args) {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        DivisionResult divisionResult = divisionCalculator.divide(78945, 4);
        DivisionFormatter divisionFormatter = new DivisionFormatter();
        System.out.println(new DivisionFormatter().format(divisionResult));
    }
}
