package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ReadFileToStringSample {
    public static void main(String[] args) {
        // Here we create an instance of File for sample.txt file.
        File file = new File("sample.txt");

        try {
            // Read the entire contents of sample.txt
            String content = FileUtils.readFileToString(file, "UTF-8");
            System.out.println("File content: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
