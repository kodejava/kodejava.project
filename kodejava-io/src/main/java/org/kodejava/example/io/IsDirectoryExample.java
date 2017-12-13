package org.kodejava.example.io;

import java.io.File;

public class IsDirectoryExample {
    public static void main(String[] args) {
        // Creates a instance of File.
        File file = new File("/home/foo/bar");

        // Check if the abstract pathname is a directory by calling
        // isDirectory() method of the File class.
        if (file.isDirectory()) {
            System.out.println("This file is a directory.");
        } else {
            System.out.println("This is just an ordinary file.");
        }
    }
}
