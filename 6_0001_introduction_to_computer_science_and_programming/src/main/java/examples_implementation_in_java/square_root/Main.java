/**
 * An algorithm for finding a square root of a number.
 * 1. Start with a guess.
 * 2. If g*g is close enough to x, stop and say g is the answer.
 * 3. Otherwise make a new guess by averaging g and x/g.
 * 4. Using the new guess, repeat process until close enough.
 */

package examples_implementation_in_java.square_root;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random r = new Random();

        double number;
        double newGuess;

        try {
            number = Double.parseDouble(br.readLine());
            double guess = r.nextInt((int)number/2);

            while (Math.abs(Math.pow(guess, 2d) - number) > 0.001) {
                newGuess = (guess + number/guess)/2;
                guess = newGuess;
            }

            System.out.println(guess);

        } catch (Exception e) {
            System.out.println("Not a number");
        }

    }
}