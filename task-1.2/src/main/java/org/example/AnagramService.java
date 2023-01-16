package org.example;

import java.util.Stack;

public class AnagramService {
    public String reverseWords(String sentence) {
        if (sentence == null) {
            return "";
        }
        StringBuilder anagramSentence = new StringBuilder();
        for (String word : sentence.split(" ")) {
            anagramSentence.append(reverseWord(word));
            anagramSentence.append(" ");
        }
        return anagramSentence.toString().trim();
    }

    private String reverseWord(String word) {
        Stack<Character> letters = getLetters(word);
        StringBuilder anagramWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                anagramWord.append(letters.pop());
            } else {
                anagramWord.append(c);
            }
        }
        return anagramWord.toString();
    }

    private Stack<Character> getLetters(String string) {
        Stack<Character> letters = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                letters.push(string.charAt(i));
            }
        }
        return letters;
    }
}
