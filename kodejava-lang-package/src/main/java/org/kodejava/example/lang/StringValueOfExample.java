package org.kodejava.example.lang;

public class StringValueOfExample {
    public static void main(String[] args) {
        boolean b = false;
        char c = 'c';
        int i = 100;
        long l = 100000;
        float f = 3.4f;
        double d = 500.99;

        System.out.println("b = " + String.valueOf(b));
        System.out.println("c = " + String.valueOf(c));
        System.out.println("i = " + String.valueOf(i));
        System.out.println("l = " + String.valueOf(l));
        System.out.println("f = " + String.valueOf(f));
        System.out.println("d = " + String.valueOf(d));
    }
}
