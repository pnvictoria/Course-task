package org.example;

public class App {
    public static void main(String[] args) {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        DivisionResult divisionResult = divisionCalculator.divide(78945, 4);
        DivisionFormatter divisionFormatter = new DivisionFormatter();
        String output = divisionFormatter.format(divisionResult);

        System.out.println(output);
    }
}
