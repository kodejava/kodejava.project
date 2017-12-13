package org.kodejava.example.math;

public class HypotExample {
    public static void main(String[] args) {
        double number1 = 3.0d;
        double number2 = 5.0d;

        // calculate square root of total value of
        // number1 ^ 2 + number2 ^ 2
        double sqr = Math.hypot(number1, number2);

        System.out.println("Total value = " + (Math.pow(number1, 2) + Math.pow(number2, 2)));
        System.out.println("Square root = " + sqr);
    }
}
