package examples_implementation_in_java.bisection_search_cube_root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double input = Double.parseDouble(br.readLine());
        System.out.println(getCubeRoot(input));
    }

    public static double getCubeRoot(double input) {
        double epsilon = 0.01;
        double low = 0, high = 0;
        boolean isNegative = false;
        double guess = 0;

        if (input < 0) {
            input = Math.abs(input);
            isNegative = true;
        }

        if (input >= 1) {
            low = 1;
            high = input;
        } else if (input > 0 && input < 1) {
            low = input;
            high = 1;
        } else if (input == 0) {
            return guess;
        }

        guess = (high + low)/2.0;

        while (Math.abs(Math.pow(guess, 3) - input) >= epsilon) {
            if (Math.pow(guess, 3) < input) {
                low = guess;
            } else {
                high = guess;
            }

            guess = (high + low) / 2.0;
        }

        if (isNegative) {
            guess *=(-1);
        }

        return guess;
    }
}
