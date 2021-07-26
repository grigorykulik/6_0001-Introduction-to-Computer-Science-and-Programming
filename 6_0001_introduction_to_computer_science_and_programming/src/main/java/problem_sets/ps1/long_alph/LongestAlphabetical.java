package problem_sets.ps1.long_alph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Assume [s] is a string of lower case characters.
 * Write a [longestAlphabetic] function that returns the longest substring of s in which the letters occur in alphabetical order.
 * For example, if s = "azcbobobegghakl", then your function should return "beggh"
 *
 * In the case of ties, return the first substring.
 * For example, if s = "abcbcd", then your function should return "abc"
 *
 * Note: This problem may be challenging.
 * We encourage you to work smart.
 * If you've spent more than a few hours on this problem,
 * we suggest that you move on to a different part of the course.
 * If you have time, come back to this problem after you've had a break and cleared your head.
 */


public class LongestAlphabetical {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(longestAlphabetic(input));
    }

    public static String longestAlphabetic(String s) {

        String longest = "";
        StringBuilder candidate = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (candidate.length() != 0 && candidate.charAt(candidate.length() - 1) > c) {
                if (longest.length() < candidate.length()) {
                    longest = candidate.toString();
                }
                candidate.delete(0, candidate.length());
            }

            candidate.append(c);
        }

        return longest.length() < candidate.length() ? candidate.toString() : longest;
    }
}
