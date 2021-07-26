package examples_implementation_in_java.multiplication_via_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(br.readLine());
        Integer b = Integer.parseInt(br.readLine());
        System.out.println(multiply(a, b));
    }

    public static int multiply(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a + multiply(a, b-1);
        }
    }
}
