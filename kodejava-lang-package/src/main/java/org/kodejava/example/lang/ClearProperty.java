package org.kodejava.example.lang;

public class ClearProperty {
    public static void main(String[] args) {
        String key = "user.dir";
        System.out.println(key + " = " + System.getProperty(key));

        // The System.clearProperty() method available in Java 1.5
        System.clearProperty(key);
        System.out.println(key + " = " + System.getProperty(key));
    }
}
