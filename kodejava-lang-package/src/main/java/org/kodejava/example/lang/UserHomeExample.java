package org.kodejava.example.lang;

public class UserHomeExample {
    public static void main(String[] args) {
        // This is the key that we used to obtain user home directory
        // in the operating system
        String userHome = "user.home";

        // We get the path by getting the system property with the 
        // defined key above.
        String path = System.getProperty(userHome);

        // We print your home path here
        System.out.println("Your Home Path: " + path);
    }
}
