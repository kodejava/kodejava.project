package org.kodejava.example.io;

import java.io.File;

public class FileSystemRoot {
    public static void main(String[] args) {
        // List the available filesystem roots.
        File[] root = File.listRoots();

        // Iterate the entire filesystem roots.
        for (File file : root) {
            System.out.println("Root: " + file.getAbsolutePath());
        }
    }
}
