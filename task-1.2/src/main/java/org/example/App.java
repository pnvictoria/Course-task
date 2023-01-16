package org.example;

public class App {
    public static void main(String[] args) {
        AnagramService anagramService = new AnagramService();
        String test = "abcd efgh";
        String test2 = "a1bcd";
        String test3 = "";
        String test4 = null;
        System.out.println(anagramService.reverseWords(test3));
    }
}
