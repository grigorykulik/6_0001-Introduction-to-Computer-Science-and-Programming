import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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


/**
 * Solution:
 * 1. Create three counters, a map, and a StringBuilder.
 * 2. Set the first counter i to zero, set the second one (j) to i+1, set the third one (sizeCounter) to 0.
 * 3. If array[i] > array[j], increment i, increment j. sizeCounter remains equal to 0.
 * 4. Else, if i < j, set sizeCounter equal to 2. Append array[i] and array[j] to the StringBuilder object.
 * 5. Increment i, increment j.
 * 6. If i > j, put the StringBuilder object and the sizeCounter to the Map.
 * 7. Else, if i < j, increment i, increment j, increment sizeCounter.
 * 8. Repeat the previous steps.
 * 9. Conditions for the loop: i <
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(longestAlphabetic(input));
    }

    public static String longestAlphabetic(String s) {
        String result = "";

        char[] array = s.toCharArray();
        int i = 0, j = 1, sizeCounter = 0;

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        if (s.length() == 1) {
            result = s;
            return result;
        }

        while (i < array.length - 1) {
            String firstChar = String.valueOf(array[i]);
            String secondChar = String.valueOf(array[j]);

            System.out.println(firstChar.compareTo(secondChar));

            if (firstChar.compareTo(secondChar) > 0) {
                i++;
                j++;

                if (!sb.toString().equals("")) {
                    map.put(sb.toString(), sizeCounter);
                }

                sb.delete(0, sb.length());
            } else {
                if (sb.length() == 0) {
                    sizeCounter = 2;
                    sb.append(array[i]);
                    sb.append(array[j]);
                    i++;
                    j++;
                } else {
                    sizeCounter++;
                    sb.append(array[j]);
                    i++;
                    j++;
                }
            }
        }

        if (sb.length() > 0 && map.size() == 0) {
            map.put(sb.toString(), sizeCounter);
        }

        Optional<Map.Entry<String, Integer>> maxEntry = map
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        try {
            result = maxEntry.get().getKey();
        } catch (NoSuchElementException e) {
            System.out.println("There are no characters " +
                    "in the string that follow one another alphabetically");
        }

        return result;
    }
}
