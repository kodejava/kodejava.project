package org.kodejava.example.basic;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo {
    public static void main(String[] args) {
        CreateFileDemo demo = new CreateFileDemo();
        try {
            demo.create("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(String path) throws IOException {
        File file = new File(path, "abc.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
