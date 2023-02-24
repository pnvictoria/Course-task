package org.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class FileService {
    public List<String> read(String fileName) {
        try {
            return List.of(readFile(getFileFromResourses(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] readFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             Stream<String> stream = reader.lines()) {
            return stream.toArray(String[]::new);
        } catch (IOException e) {
            throw new IOException("Exception while reading " + e.getMessage());
        }
    }

    private File getFileFromResourses(String fileName) throws IOException {
        if (getClass().getClassLoader().getResource(fileName) == null)
            throw new IOException("File \"" + fileName + "\" not found");
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }
}
