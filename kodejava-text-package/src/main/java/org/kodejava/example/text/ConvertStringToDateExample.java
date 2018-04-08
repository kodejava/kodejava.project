package org.kodejava.example.text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertStringToDateExample {
    public static void main(String[] args) {
        String pattern = "dd/MM/yyyy";
        String date = "28/01/2018";

        try {
            DateFormat df = new SimpleDateFormat(pattern);
            Date today = df.parse(date);
            System.out.println("Today = " + df.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Using Java 8 Date and Time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("Today = " + localDate.format(formatter));
    }
}
