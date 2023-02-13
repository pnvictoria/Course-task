package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CharacterCounter counter = new CharacterCounter();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter string line to count the number of unique characters:");
                System.out.println(counter.characterCounting(scanner.nextLine()));
            }
        } catch (RuntimeException e) {
            System.out.println("System error");
        }
    }
}
