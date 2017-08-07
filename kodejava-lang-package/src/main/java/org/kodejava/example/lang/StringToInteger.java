package org.kodejava.example.lang;

public class StringToInteger {
    public static void main(String[] args) {
        // Some random selected number, could representing a decimal,
        // hexadecimal or octal number.
        String myLuckyNumber = "13";

        // We convert a string to an integer by invoking parseInt() method
        // of the Integer class.
        Integer number = Integer.parseInt(myLuckyNumber);
        System.out.println("My lucky number is: " + number);

        // We can also converting a string representation of a number other
        // then the decimal base, for instance an hexadecimal by providing
        // the radix to the method.
        number = Integer.parseInt(myLuckyNumber, 16);
        System.out.println("My lucky number is: " + number);

        number = Integer.parseInt(myLuckyNumber, 8);
        System.out.println("My lucky number is: " + number);
    }
}
