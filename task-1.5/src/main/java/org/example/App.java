package org.example;

import org.example.loader.RaceFilesDataLoader;

public class App {
    public static void main(String[] args) {
        RaceFilesDataLoader reader = new RaceFilesDataLoader();
        System.out.println(reader.orderRacers());
    }
}
