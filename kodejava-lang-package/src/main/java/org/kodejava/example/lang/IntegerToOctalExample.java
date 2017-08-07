package org.kodejava.example.lang;

public class IntegerToOctalExample {
    public static void main(String[] args) {
        int integer = 1024;
        // Converting integer value to octal string representation.
        String octal = Integer.toOctalString(integer);
        System.out.printf("Octal value of %d is '%s'.\n", integer, octal);

        // Now we converting back from octal string to integer
        // by calling Integer.parseInt and passing 8 as the radix.
        int original = Integer.parseInt(octal, 8);
        System.out.printf("Integer value of octal '%s' is %d.%n", octal, original);

        // When for formatting purposes we can actually use printf
        // or String.format to display an integer value in other
        // format (o = octal, h = hexadecimal).
        System.out.printf("Octal value of %1$d is '%1$o'.\n", integer);
    }
}
