package org.kodejava.example.math;

import java.math.BigInteger;

public class BigIntegerOperation {
    public static void main(String[] args) {
        BigInteger numberA = new BigInteger("98765432123456789");
        BigInteger numberB = BigInteger.TEN;

        numberA = numberA.add(numberB);
        System.out.println("numberA = " + numberA);

        numberA = numberA.multiply(numberB);
        System.out.println("numberA = " + numberA);

        numberA = numberA.subtract(numberB);
        System.out.println("numberA = " + numberA);

        numberA = numberA.divide(numberB);
        System.out.println("numberA = " + numberA);

        numberA = numberA.mod(numberB);
        System.out.println("numberA = " + numberA);

        numberA = numberA.pow(2);
        System.out.println("numberA = " + numberA);

        numberA = numberA.negate();
        System.out.println("numberA = " + numberA);
    }
}
