package org.kodejava.example.text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatToPattern {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("EEEE, dd/MM/yyyy");

        // Gets a pattern string describing this date format used by the
        // SimpleDateFormat object.
        String pattern = format.toPattern();

        System.out.println("Pattern = " + pattern);
        System.out.println("Date    = " + format.format(new Date()));
    }
}
