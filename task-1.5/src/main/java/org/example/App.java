package org.example;

import org.example.view.RaceResult;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        RaceResult reader = new RaceResult();
        System.out.println(reader.getRaceResult());
    }
}
