package org.kodejava.example.math;

public class LogarithmExample {

    public static void main(String[] args) {
        double number1 = 1000.0d;

        // Get common logarithm
        double log10 = Math.log10(number1);
        System.out.println("Common logarithm of " + number1 + " = " + log10);

        // Get natural logarithm
        double loge = Math.log(number1);
        System.out.println("Natural logarithm of " + number1 + " = " + loge);
    }
}
