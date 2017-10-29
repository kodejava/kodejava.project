package org.kodejava.example.util;

import java.util.Arrays;

public class SortArrayCaseSensitivity {
    public static void main(String[] args) {
        String[] teams = new String[5];
        teams[0] = "Manchester United";
        teams[1] = "chelsea";
        teams[2] = "Arsenal";
        teams[3] = "liverpool";
        teams[4] = "EVERTON";

        // Sort array, by default it will be sort in case sensitive order.
        // [Arsenal, EVERTON, Manchester United, chelsea, liverpool]
        Arrays.sort(teams);
        System.out.println("Case sensitive  : " + Arrays.toString(teams));

        // Sort array in case insensitive order
        // [Arsenal, chelsea, EVERTON, liverpool, Manchester United]
        Arrays.sort(teams, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case insensitive: " + Arrays.toString(teams));
    }
}
