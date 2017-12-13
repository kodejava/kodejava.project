package org.kodejava.example.math;

public class TrigonometricExample {
    public static void main(String[] args) {
        double radians = 1.0d;

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tan = Math.tan(radians);

        double asine = Math.asin(sine);
        double acosine = Math.acos(cosine);
        double atan = Math.atan(tan);

        System.out.println("Sine of " + radians + " = " + sine);
        System.out.println("Cosine of " + radians + " = " + cosine);
        System.out.println("Tangent of " + radians + " = " + tan);
        System.out.println("Arcsine of " + sine + " = " + asine);
        System.out.println("Arccosine of " + cosine + " = " + acosine);
        System.out.println("Arctangent of " + tan + " = " + atan);
    }
}
