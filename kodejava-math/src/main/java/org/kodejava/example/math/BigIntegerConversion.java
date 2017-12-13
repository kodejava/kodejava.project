package org.kodejava.example.math;

import java.math.BigInteger;

public class BigIntegerConversion {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("2017");

        System.out.println("Number      = " + number);
        System.out.println("Binary      = " + number.toString(2));
        System.out.println("Octal       = " + number.toString(8));
        System.out.println("Hexadecimal = " + number.toString(16));

        number = new BigInteger("FF", 16);
        System.out.println("Number      = " + number);
        System.out.println("Number      = " + number.toString(16));
    }
}
