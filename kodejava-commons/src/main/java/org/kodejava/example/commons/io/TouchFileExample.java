package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TouchFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("Touch.dat");

            // Touch the file, when the file is not exist a new file will be
            // created. If the file exist change the file timestamp.
            FileUtils.touch(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
