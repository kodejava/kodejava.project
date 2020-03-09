package org.kodejava.example.commons.io;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileToByteArray {
    public static void main(String[] args) {
        File file = new File("data.txt");
        try {
            InputStream is = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(is);

            System.out.println("Byte array size: " + bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
