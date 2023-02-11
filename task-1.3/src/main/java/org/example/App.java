package org.example;

import org.example.division.DivisionService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean isExit = false;
        DivisionService divisionService = new DivisionService();
        try (Scanner scanner = new Scanner(System.in)) {
            while (!isExit) {
                System.out.println("********************************");
                System.out.println(" 1. Divide numbers;");
                System.out.println(" 0. Exit;");
                System.out.print("Answer: ");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        System.out.print("Dividend:");
                        int dividend = scanner.nextInt();
                        System.out.print("Dividend:");
                        int divider = scanner.nextInt();
                        System.out.println("Result :" + System.lineSeparator() + divisionService.divide(dividend, divider));
                        break;
                    case 0:
                        System.out.println("The program was closed.");
                        isExit = true;
                        break;
                    default:
                        System.out.println("Incorrect number.");
                        break;
                }
            }
        } catch (RuntimeException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
