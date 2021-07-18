/**
 * Assume
 *
 * @param s is a string of lower case characters.
 *          Write a function that
 * @return the number of times the string "bob" occurs in s.
 * For example, if s = 'azcbobobegghakl', then your [numberOfBobs] should return 2
 */

/**
 * 1. We need a counter i. This counter goes from position 0 to position s.length() - 3.
 * 2. If s.charAt(i) == b and s.charAt(i+1) == o and s.charAt(i+2) == b then increment bobsCounter.
 * 3. Else i = i+3;
 */
package problem_sets.ps1.number_of_bobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class NumberOfBobs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(numberOfBobs(input));
    }

    public static int numberOfBobs(String s) {
// version 1
//        int bobsCounter = 0;
//
//        for (int i = 0; i <= s.length() - 3; i++) {
//
//            if (s.startsWith("bob", i)) {
//                bobsCounter++;
//            }
//        }

        // version 2
        return (int) IntStream.rangeClosed(0, s.length() - 3)
                .filter(i -> s.startsWith("bob", i))
                .count();

    }
}