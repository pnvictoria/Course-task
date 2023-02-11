package org.example;

import java.util.*;


class CharacterCounter {
    private Map<String, String> cache = new HashMap<>();
    private static final String SEPARATOR = System.lineSeparator();

    public String computeStatistics(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        Map<Character, Integer> countedChars = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            countedChars.put(ch, countedChars.getOrDefault(ch, 0) + 1);
        }
        String result = buildStatsView(countedChars);
        cache.put(input, result);
        return result;
    }

    private String buildStatsView(Map<Character, Integer> countedChars) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countedChars.entrySet()) {
            result.append(String.format("\"%s\" - %s%s", entry.getKey(), entry.getValue(), SEPARATOR));
        }
        return result.toString();
    }
}
