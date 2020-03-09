package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.math.BigInteger;

public class DirectorySizeSample {
    public static void main(String[] args) {
        // sizeOfDirectory
        File tempDir = new File("/Users/wayan/Temp");
        long size = FileUtils.sizeOfDirectory(tempDir);
        System.out.println("TempDir size = " + size + " bytes");
        System.out.println("TempDir size = " +
                FileUtils.byteCountToDisplaySize(size));

        // sizeOfDirectoryAsBigInteger()
        File dropboxDir = new File("/Users/wayan/Dropbox");
        BigInteger sizeBig = FileUtils.sizeOfDirectoryAsBigInteger(dropboxDir);
        System.out.println("DropboxDir size = " + sizeBig);
        System.out.println("DropboxDir size = " +
                FileUtils.byteCountToDisplaySize(sizeBig));
    }
}
