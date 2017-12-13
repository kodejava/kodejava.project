package org.kodejava.example.math;

public class PowerExample {

    public static void main(String[] args) {
        double cubeRoot = 5d;

        // Get the cubed number of cube root
        // x cubed = x^3 (multiplication three times)
        double cubed = Math.pow(cubeRoot, 3);
        System.out.println(cubeRoot + " cubed is " + cubed);
    }
}
