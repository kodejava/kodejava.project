package org.kodejava.example.math;

public class RadiansDegreeConversionExample {
    public static void main(String[] args) {
        double radians = 1.0d;
        double degrees = 45d;

        // Converts an angle measured in radians to an
        // approximately equivalent angle measured in
        // degrees.
        double toDegree = Math.toDegrees(radians);

        // Converts an angle measured in degrees to an
        // approximately equivalent angle measured in
        // radians.
        double toRadians = Math.toRadians(degrees);

        System.out.println("Radians " + radians + " in degrees  = " + toDegree);
        System.out.println("Degrees " + degrees + " in radians = " + toRadians);
    }
}
