package org.kodejava.example.lang;

public class EscapePercentSignExample {
    public static void main(String[] args) {
        String format = "The current bank interest rate is %6.2f%%.%n";
        System.out.printf(format, 10f);
    }
}
