package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class URLToFile {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            File destination = new File("../demo/google.html");

            // Copy bytes from the URL to the destination file.
            FileUtils.copyURLToFile(url, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
