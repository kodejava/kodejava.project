package org.kodejava.example.io;

import java.io.*;

public class WriteTextFileExample {
    public static void main(String[] args) {
        File file = new File("write.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            String contents = "The quick brown fox" +
                System.getProperty("line.separator") + "jumps over the lazy dog.";

            writer.write(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
