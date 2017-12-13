package org.kodejava.example.math;

public class ExponentExample {

    public static void main(String[] args) {
        double x = 0.0d;

        // calculates e raised to the power of x (e^x)
        double fx = Math.exp(x);

        // calculates e raised to the power of x minus 1 (e^x - 1)
        double fxm1 = Math.expm1(x);

        System.out.println("fx   = " + fx);
        System.out.println("fxm1 = " + fxm1);
    }
}
