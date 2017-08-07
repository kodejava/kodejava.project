package org.kodejava.example.lang;

public class JavaVersion {
    public static void main(String[] args) {
        // You can get the version of Java Runtime Environment
        // running on your machine by reading the "java.version"
        // property value from the system.
        String version = System.getProperty("java.version");

        // Just show to the world your JRE version :)
        System.out.println("Java Version = " + version);
    }
}
