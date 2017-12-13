package org.kodejava.example.io;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileCopy {
    public static void main(String[] args) {
        //// Define the source and target file
        File source = new File("D:/Temp/source.txt");
        File target = new File("D:/Temp/target.txt");

        // Create the source and target channel
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(target).getChannel()) {
            // Copy data from the source channel into the target
            // channel
            targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
