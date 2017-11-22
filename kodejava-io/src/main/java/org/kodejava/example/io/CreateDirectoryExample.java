package org.kodejava.example.io;

import java.io.File;

public class CreateDirectoryExample {
    public static void main(String[] args) {
        File file = new File("tmpdir");

        if (file.mkdir()) {
            System.out.println("Directory = " + file.getAbsolutePath() + ".");
        } else {
            System.out.println("No directory was created.");
        }
    }
}
