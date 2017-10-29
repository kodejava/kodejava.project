package org.kodejava.example.util;

import java.util.Arrays;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();

        // generate some random boolean values
        boolean[] booleans = new boolean[10];
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = r.nextBoolean();
        }
        System.out.println(Arrays.toString(booleans));

        // generate a uniformly distributed int random numbers
        int[] integers = new int[10];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = r.nextInt();
        }
        System.out.println(Arrays.toString(integers));

        // generate a uniformly distributed float random numbers
        float[] floats = new float[10];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = r.nextFloat();
        }
        System.out.println(Arrays.toString(floats));

        // generate a Gaussian normally distributed random numbers
        double[] doubles = new double[10];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = r.nextGaussian();
        }
        System.out.println(Arrays.toString(doubles));
    }
}
