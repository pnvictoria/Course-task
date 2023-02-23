package org.example;

public class App {
    public static void main(String[] args) {
        RaceFilesDataLoader reader = new RaceFilesDataLoader();
        System.out.println(reader.orderRacers());
    }
}
