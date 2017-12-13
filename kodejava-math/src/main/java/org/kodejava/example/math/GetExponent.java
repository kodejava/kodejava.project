package org.kodejava.example.math;

public class GetExponent {
    public static void main(String[] args) {
        double fx = 1.0d;
        float fx1 = 1.0f;

        int x = Math.getExponent(fx);
        System.out.println("Exponent  = " + x);

        // argument in float
        int xf = Math.getExponent(fx1);
        System.out.println("Exponent1 = " + xf);
    }
}
