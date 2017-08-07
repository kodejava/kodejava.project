package org.kodejava.example.lang;

public class GettingUserName {
    public static void main(String[] args) {
        String username = System.getProperty("user.name");
        System.out.println("username = " + username);
    }
}
