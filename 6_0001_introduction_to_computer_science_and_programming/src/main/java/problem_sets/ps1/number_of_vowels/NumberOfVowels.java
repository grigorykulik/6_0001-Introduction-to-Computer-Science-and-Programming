/**
 * Assume
 *
 * @param s is a string of lower case characters.
 *          Write a function that
 * @return the number of vowels contained in the string s.
 * Valid vowels are: 'a', 'e', 'i', 'o', and 'u'.
 * For example, if [s] = "azcbobobegghakl", your [numberOfVowels] should return 5
 */

package problem_sets.ps1.number_of_vowels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfVowels {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(numberOfVowels(input));
    }

    public static int numberOfVowels(String s) {
//        int vowelCounter = 0;
//
//        for (char c : s.toCharArray()) if ("aeiou".indexOf(c) >= 0) vowelCounter++;

        // Более преподч. вариант
        return (int) s.chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();
    }
}
