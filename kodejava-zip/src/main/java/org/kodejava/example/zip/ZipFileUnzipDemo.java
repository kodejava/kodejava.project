package org.kodejava.example.zip;

import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.Enumeration;
import java.io.*;

public class ZipFileUnzipDemo {
    public static void main(String[] args) throws Exception {
        String zipName = "data.zip";

        ZipFile zip = new ZipFile(zipName);
        Enumeration enumeration = zip.entries();

        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
            System.out.println("Unzipping: " + zipEntry.getName());

            int size;
            byte[] buffer = new byte[2048];

            try (BufferedInputStream bis =
                     new BufferedInputStream(zip.getInputStream(zipEntry));
                 FileOutputStream fos =
                     new FileOutputStream(zipEntry.getName());
                 BufferedOutputStream bos =
                     new BufferedOutputStream(fos, buffer.length)) {

                while ((size = bis.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, size);
                }
                bos.flush();
            }
        }
    }
}
