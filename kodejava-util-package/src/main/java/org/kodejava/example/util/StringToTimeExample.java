package org.kodejava.example.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToTimeExample {
    public static void main(String[] args) {
        // A string of time information
        String time = "15:30:18";

        // Create an instance of SimpleDateFormat with the specified
        // format.
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            // To get the date object from the string just called the 
            // parse method and pass the time string to it. This method 
            // throws ParseException if the time string is invalid. 
            // But remember as we don't pass the date information this 
            // date object will represent the 1st of january 1970.
            Date date = sdf.parse(time);
            System.out.println("Date and Time: " + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
