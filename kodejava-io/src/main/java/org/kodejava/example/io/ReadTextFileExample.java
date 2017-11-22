package org.kodejava.example.io;

import java.io.*;

public class ReadTextFileExample {
    private static String lineSeparator = System.getProperty("line.separator");

    public static void main(String[] args) {
        File file = new File("README.md");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder contents = new StringBuilder();
            String text;
            while ((text = reader.readLine()) != null) {
                contents.append(text).append(lineSeparator);
            }

            System.out.println(contents.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
