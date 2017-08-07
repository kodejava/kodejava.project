package org.kodejava.example.lang;

import java.util.Calendar;
import java.math.BigDecimal;

public class ClassName {
    public static void main(String[] args) {
        // Get the name of the classes below.
        Class clazz = String.class;
        System.out.println("Class Name: " + clazz.getName());

        clazz = Calendar.class;
        System.out.println("Class Name: " + clazz.getName());

        clazz = BigDecimal.class;
        System.out.println("Class Name: " + clazz.getName());
    }
}
