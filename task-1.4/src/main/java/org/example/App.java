package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CharacterCounter counter = new CharacterCounter();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Enter string line to count the number of unique characters:");
                String input = reader.readLine();
                System.out.println(counter.computeStatistics(input));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("System error");
        }
    }
}
