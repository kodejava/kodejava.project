package org.kodejava.example.lang;

public class FileSeparatorExample {
    public static void main(String[] args) {
        // file.separator syste property return the correct file
        // separator for each different platform (Windows = \),
        // (Linux = /)
        String dataFolder = System.getProperty("user.dir") +
            System.getProperty("file.separator") + "data";

        System.out.println("Data Folder = " + dataFolder);
    }
}
