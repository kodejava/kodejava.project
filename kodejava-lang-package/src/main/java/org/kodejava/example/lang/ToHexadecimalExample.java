package org.kodejava.example.lang;

public class ToHexadecimalExample {
    public static void main(String[] args) {
        // Converting a decimal value to its hexadecimal representation 
        // can be done using Integer.toHexString() method.
        System.out.println(Integer.toHexString(1976));

        // On the other hand to convert hexadecimal string to decimal
        // we can use Integer.parseInt(string, radix) method, 
        // where radix for hexadecimal is 16.
        System.out.println(Integer.parseInt("7b8", 16));
    }
}
