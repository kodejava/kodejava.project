package org.kodejava.example;

import java.text.NumberFormat;
import java.util.Locale;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
        System.out.println(nf.format(1000));
        System.out.println(nf.format(1000000));
    }
}
