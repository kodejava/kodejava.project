package org.kodejava.example.commons.io;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class DiskFreeSpace {
    public static void main(String[] args) {
        try {
            String path = "/Users/wayan";
            long freeSpaceKB = FileSystemUtils.freeSpaceKb(path);
            long freeSpaceMB = freeSpaceKB / FileUtils.ONE_KB;
            long freeSpaceGB = freeSpaceKB / FileUtils.ONE_MB;

            System.out.println("Size of " + path + " = " + freeSpaceKB + " KB");
            System.out.println("Size of " + path + " = " + freeSpaceMB + " MB");
            System.out.println("Size of " + path + " = " + freeSpaceGB + " GB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
