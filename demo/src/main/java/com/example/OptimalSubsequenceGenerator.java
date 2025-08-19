package com.example;

import java.util.*;

public class OptimalSubsequenceGenerator {
    
    public static List<List<Character>> getAllUniqueSubsequences(String s) {
        List<List<Character>> result = new ArrayList<>();
        List<Character> current = new ArrayList<>();
        
        // Sort the string to handle duplicates efficiently
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        generateSubsequences(0, chars, result, current);
        return result;
    }
    
    private static void generateSubsequences(int i, char[] chars, 
                                           List<List<Character>> result, 
                                           List<Character> current) {
        // Base case: we've processed all characters
        if (i == chars.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Include current character
        current.add(chars[i]);
        generateSubsequences(i + 1, chars, result, current);
        current.remove(current.size() - 1); // backtrack
        
        // Skip all duplicate characters to avoid duplicate subsequences
        while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
            i++;
        }
        
        // Exclude current character (and all its duplicates)
        generateSubsequences(i + 1, chars, result, current);
    }
    
    // String version for easier visualization
    public static List<String> getAllUniqueSubsequencesAsStrings(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        generateSubsequencesString(0, chars, result, current);
        return result;
    }
    
    private static void generateSubsequencesString(int i, char[] chars, 
                                                 List<String> result, 
                                                 StringBuilder current) {
        if (i == chars.length) {
            result.add(current.toString());
            return;
        }
        
        // Include current character
        current.append(chars[i]);
        generateSubsequencesString(i + 1, chars, result, current);
        current.deleteCharAt(current.length() - 1); // backtrack
        
        // Skip duplicates
        while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
            i++;
        }
        
        // Exclude current character
        generateSubsequencesString(i + 1, chars, result, current);
    }
    
    public static void main(String[] args) {
        String input = "aab";
        
        System.out.println("Input string: " + input);
        
        // Test the optimized method
        List<List<Character>> result = getAllUniqueSubsequences(input);
        
        System.out.println("\nAll unique subsequences as List<List<Character>>:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + ": " + result.get(i));
        }
        
        System.out.println("\nAll unique subsequences as strings:");
        List<String> stringResult = getAllUniqueSubsequencesAsStrings(input);
        for (int i = 0; i < stringResult.size(); i++) {
            System.out.println(i + ": \"" + stringResult.get(i) + "\"");
        }
        
        System.out.println("\nTotal unique subsequences: " + result.size());
        
        // Test with more examples
        testWithInput("abc");
        testWithInput("aaa");
        testWithInput("aabb");
    }
    
    private static void testWithInput(String input) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Testing with input: \"" + input + "\"");
        
        List<String> result = getAllUniqueSubsequencesAsStrings(input);
        System.out.println("Subsequences: " + result);
        System.out.println("Count: " + result.size());
    }
}