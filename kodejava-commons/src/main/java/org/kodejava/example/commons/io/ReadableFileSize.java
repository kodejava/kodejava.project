package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class ReadableFileSize {
    public static void main(String[] args) {
        File file = new File("/Users/wayan/Downloads/lunaInstaller.app");

        long size = file.length();
        String display = FileUtils.byteCountToDisplaySize(size);

        System.out.println("Name    = " + file.getName());
        System.out.println("Size    = " + size);
        System.out.println("Display = " + display);
    }
}
