package org.kodejava.example.lang;

public class BooleanParseExample {
    public static void main(String[] args) {
        // Parsing string "true" will result boolean true
        boolean boolA = Boolean.parseBoolean("true");
        System.out.println("boolA = " + boolA);

        // Parsing string "TRUE" also result boolean true, as the
        // parsing method is case insensitive
        boolean boolB = Boolean.parseBoolean("TRUE");
        System.out.println("boolB = " + boolB);

        // The operation below will return false, as Yes is not
        // a valid string value for boolean expression
        boolean boolC = Boolean.parseBoolean("Yes");
        System.out.println("boolC = " + boolC);

        // Parsing a number is also not a valid expression so the
        // parsing method return false
        boolean boolD = Boolean.parseBoolean("1");
        System.out.println("boolD = " + boolD);
    }
}
