package org.kodejava.example.util;

import java.util.GregorianCalendar;

public class LeapYearExample {
    public static void main(String[] args) {
        // Here we show how to know if a specified year is a leap year or 
        // not. The GregorianCalendar object provide a convenient method 
        // to do this. The method is GregorianCalendar.isLeapYear().

        // First, let's obtain an instance of GregorianCalendar.
        GregorianCalendar cal = new GregorianCalendar();

        // The isLeapYear(int year) method will return true for leap 
        // year and otherwise return false. In this example the message 
        // will be printed as 2016 is a leap year.
        if (cal.isLeapYear(2016)) {
            System.out.println("The year 2016 is a leap year!");
        }
    }
}
