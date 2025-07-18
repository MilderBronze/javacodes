package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EditDistanceAutoCorrector {

    static List<String> dictionary = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ✅ Try loading dictionary from classpath (resources folder)
        try {
            String dictionaryPath = Objects.requireNonNull(
                EditDistanceAutoCorrector.class.getClassLoader().getResource("words.txt")
            ).getPath();

            dictionary = loadWords(dictionaryPath);
            System.out.println("✅ Loaded dictionary with " + dictionary.size() + " words.");
        } catch (Exception e) {
            System.out.println("⚠️ Failed to load dictionary file. Using fallback word list.");
            dictionary = Arrays.asList("the", "then", "there", "that", "this", "their", "apple", "banana", "hello", "world");
        }

        while (true) {
            System.out.print("\nEnter your word (or 'exit'): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) break;

            List<String> suggestions = getSuggestions(input);
            System.out.println("Did you mean:");
            for (String suggestion : suggestions) {
                System.out.println(" - " + suggestion);
            }
        }
    }

    public static List<String> loadWords(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    static List<String> getSuggestions(String input) {
        int minDist = Integer.MAX_VALUE;
        List<String> bestMatches = new ArrayList<>();

        for (String word : dictionary) {
            int dist = editDistance(input, word);
            if (dist < minDist) {
                bestMatches.clear();
                bestMatches.add(word);
                minDist = dist;
            } else if (dist == minDist) {
                bestMatches.add(word);
            }
        }
        return bestMatches;
    }

    static int editDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[n][m];
    }
}
