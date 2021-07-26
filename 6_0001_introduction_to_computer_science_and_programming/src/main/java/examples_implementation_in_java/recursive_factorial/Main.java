package examples_implementation_in_java.recursive_factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer number = Integer.parseInt(br.readLine());
        System.out.println(getFactorial(number));
    }

    public static BigInteger getFactorial(int number) {
        if (number == 1 || number == 0) {
            return BigInteger.ONE;
        } else {
            return getFactorial(number - 1).multiply(BigInteger.valueOf(number));
        }
    }
}
