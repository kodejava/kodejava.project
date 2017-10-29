package org.kodejava.example.util;

import java.util.Arrays;

public class CompareArrayExample {
    public static void main(String[] args) {
        String[] abc = {"Kode", "Java", "Dot", "Org"};
        String[] xyz = {"Kode", "Java", "Dot", "Org"};
        String[] java = {"Java", "Dot", "Com"};

        System.out.println(Arrays.equals(abc, xyz));
        System.out.println(Arrays.equals(abc, java));
    }
}
