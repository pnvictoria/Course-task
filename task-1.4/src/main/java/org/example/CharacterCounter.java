package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class CharacterCounter {
    private static final String SEPARATOR = System.lineSeparator();
    private Map<String, String> cache = new HashMap<>();

    public String characterCounting(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        Map<Character, Integer> countedChars = new LinkedHashMap<>();
        for (char symbol : input.toCharArray()) {
            countedChars.put(symbol, countedChars.getOrDefault(symbol, 0) + 1);
        }
        String result = getView(countedChars);
        cache.put(input, result);
        return result;
    }

    private String getView(Map<Character, Integer> countedChars) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countedChars.entrySet()) {
            result.append(String.format("\"%s\" - %s%s", entry.getKey(), entry.getValue(), SEPARATOR));
        }
        return result.toString();
    }
}
