package org.kodejava.example.lang;

public class RandomNumberExample {
    public static void main(String[] args) {
        // The Math.random() returns a random number between 0.0 and 1.0 
        // including 0.0 but not including 1.0.
        double number = Math.random();
        System.out.println("Generated number: " + number);

        // By multiplying Math.random() result with a number will give
        // us a range of random number between, for instance 0.0 to 10.0 as
        // shown in the example below.
        number = Math.random() * 10;
        System.out.println("Generated number: " + number);

        // To get a random number between n and m we can use the formula:
        // n + (Math.random() * (m - n)). The example below creates random
        // number between 100.0 and 200.0.
        int n = 100;
        int m = 200;
        number = n + (Math.random() * (m - n));
        System.out.println("Generated number: " + number);

        // Creates an integer random number
        int random = 100 + (int) (Math.random() * 100);
        System.out.println("Generated number: " + random);
    }
}
