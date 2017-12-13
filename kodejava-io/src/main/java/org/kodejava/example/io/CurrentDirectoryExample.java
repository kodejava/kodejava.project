package org.kodejava.example.io;

public class CurrentDirectoryExample {
    public static void main(String[] args) {
        // System property key to get current working directory.
        String USER_DIR_KEY = "user.dir";
        String currentDir = System.getProperty(USER_DIR_KEY);

        System.out.println("Working Directory: " + currentDir);
    }
}
