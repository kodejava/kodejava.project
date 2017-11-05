package org.kodejava.example.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalePlatform {
    public static void main(String[] args) {
        ResourceBundle res;
        String language = "fr";
        String country = "FR";

        // Construct a locale from language, country, variant. Where the variant
        // can be a variant vendor and browser specific code.
        Locale unix = new Locale(language, country, "UNIX");
        res = ResourceBundle.getBundle("MessagesBundle", unix);
        System.out.println("UNIX: " + res.getString("birthday"));

        Locale mac = new Locale(language, country, "MAC");
        res = ResourceBundle.getBundle("MessagesBundle", mac);
        System.out.println("MAC : " + res.getString("birthday"));

        Locale windows = new Locale(language, country, "WIN");
        res = ResourceBundle.getBundle("MessagesBundle", windows);
        System.out.println("WIN : " + res.getString("birthday"));
    }
}
