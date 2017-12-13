package org.kodejava.example.math;

public class CubeSquareRootExample {

    public static void main(String[] args) {
        double cube = 125.0d;
        double square = 100.0d;

        // Get the cube root of double value
        double cubeRoot = Math.cbrt(cube);
        System.out.println("Cube root of " + cube + " is " + cubeRoot);

        // Get the square root of double value
        double squareRoot = Math.sqrt(square);
        System.out.println("Square root of " + square + " is " + squareRoot);
    }
}
