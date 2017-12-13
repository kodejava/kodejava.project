package org.kodejava.example.math;

public class GetAbsoluteValueExample {
    public static void main(String[] args) {
        Double value = -10.0D;

        double abs1 = Math.abs(value);
        System.out.println("Absolute value in double: " + abs1);

        float abs2 = Math.abs(value.floatValue());
        System.out.println("Absolute value in float : " + abs2);

        int abs3 = Math.abs(value.intValue());
        System.out.println("Absolute value in int   : " + abs3);

        long abs4 = Math.abs(value.longValue());
        System.out.println("Absolute value in long  : " + abs4);
    }
}
