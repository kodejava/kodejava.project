package org.kodejava.example.jdbc;

import java.util.Date;

public class UtilDateToSqlDate {
    public static void main(String[] args) {
        // Create a new instance of java.util.Date
        Date date = new Date();

        // To covert java.util.Date to java.sql.Date we need to
        // create an instance of java.sql.Date and pass the long
        // value of java.util.Date as the parameter.
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        System.out.println("Date    = " + date);
        System.out.println("SqlDate = " + sqlDate);
    }
}
