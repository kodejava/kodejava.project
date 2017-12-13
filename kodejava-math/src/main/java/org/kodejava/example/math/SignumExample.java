package org.kodejava.example.math;

public class SignumExample {

    public static void main(String[] args) {
        Double zero = 0.0D;
        Double negative = -25.0D;
        Double positive = 15.0D;

        // Get the signum function of value of a number.
        // It returns:
        // * 0 if the value is zero.
        // * 1.0 if value is greater than zero.
        // * -1.0 if value is less than zero.
        double sign1 = Math.signum(zero);
        double sign2 = Math.signum(negative);
        double sign3 = Math.signum(positive);

        // For floating-point value
        float sign4 = Math.signum(zero.floatValue());
        float sign5 = Math.signum(negative.floatValue());
        float sign6 = Math.signum(positive.floatValue());

        System.out.println("In double:");
        System.out.println("Signum of " + zero + " is " + sign1);
        System.out.println("Signum of " + negative + " is " + sign2);
        System.out.println("Signum of " + positive + " is " + sign3);

        System.out.println("In float:");
        System.out.println("Signum of " + zero + " is " + sign4);
        System.out.println("Signum of " + negative + " is " + sign5);
        System.out.println("Signum of " + positive + " is " + sign6);
    }
}
