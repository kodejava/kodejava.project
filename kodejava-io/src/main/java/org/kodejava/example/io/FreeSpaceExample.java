package org.kodejava.example.io;

import java.io.File;

public class FreeSpaceExample {
    public static void main(String[] args) {
        // We create an instance of a File to represent a partition
        // of our file system. For instance here we used a drive D:
        // as in Windows operating system.
        File file = new File("D:");

        // Using the getTotalSpace() we can get an information of
        // the actual size of the partition, and we convert it to
        // mega bytes.
        long totalSpace = file.getTotalSpace() / (1024 * 1024);

        // Next we get the free disk space as the name of the
        // method shown us, and also get the size in mega bytes.
        long freeSpace = file.getFreeSpace() / (1024 * 1024);

        // Just print out the values.
        System.out.println("Total Space = " + totalSpace + " Mega Bytes");
        System.out.println("Free Space = " + freeSpace + " Mega Bytes");
    }
}
