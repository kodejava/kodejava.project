package org.kodejava.example.math;

public class GetRoundedValueExample {

    public static void main(String[] args) {
        Double number = 1.5D;

        // Get the smallest value that is greater than or equal to the
        // argument and is equal to a mathematical integer
        double roundUp = Math.ceil(number);
        System.out.println("Result of rounding up of " + number + " = " + roundUp);

        // Get the largest value that is less than or equal to the
        // argument and is equal to a mathematical integer
        double roundDown = Math.floor(number);
        System.out.println("Result of rounding down of " + number + " = " + roundDown);

        // Get the closest long value to the argument
        long round1 = Math.round(number);
        System.out.println("Rounding result of " + number + " (in long) =  " + round1);

        // Get the closest int value to the argument
        int round2 = Math.round(number.floatValue());
        System.out.println("Rounding result of " + number + " (in int) = " + round2);
    }
}
