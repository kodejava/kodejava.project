package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WriteToFileExample {
    public static void main(String[] args) {
        try {
            // Here we'll write our data into a file called
            // output.txt, this is the output.
            File file = new File("output.txt");
            // We'll write the string below into the file
            String data = "Learn Java Programming by Examples";

            // To write a file called the writeStringToFile
            // method which require you to pass the file and
            // the data to be written.
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
