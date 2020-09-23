package com.assignment.task.util;

public class PhraseUtils {
    private PhraseUtils() {
    }

    /**
     * Splits a phrase into two equal parts without breaking the integrity of the words
     */
    public static String[] splitPhraseNicely(String phrase) {
        String[] parts = new String[2];
        String[] words = phrase.split(" ");

        StringBuilder part1 = new StringBuilder();
        StringBuilder part2 = new StringBuilder();

        int partLength = phrase.length() / 2;

        for (String word : words) {
            if (part2.length() == 0 && (part1.length() == 0 || part1.length() + word.length() + 1 < partLength)) {
                part1.append(" ").append(word);
            } else {
                part2.append(" ").append(word);
            }
        }
        parts[0] = part1.toString().trim();
        parts[1] = part2.toString().trim();
        return parts;
    }
}
