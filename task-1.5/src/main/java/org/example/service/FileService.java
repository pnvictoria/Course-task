package org.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
    public List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
