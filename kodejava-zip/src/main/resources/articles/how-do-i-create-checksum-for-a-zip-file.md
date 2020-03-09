# How do I create checksum for a zip file?

This example demonstrate how to use `CheckedOutputStream` for creating a checksum of a zip file. Checksum can be used to detect whether a data was corrupted during a transmission process to a remote machine.

```java
package org.kodejava.example.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Adler32;

public class ZipWithChecksum {
    public static void main(String[] args) throws Exception {
        String target = "data-1.zip";

        try (FileOutputStream fos = new FileOutputStream(target);
             // An output stream that also maintains a checksum of the data
             // being written. The checksum can then be used to verify the
             // integrity of the output data.
             CheckedOutputStream checksum =
                 new CheckedOutputStream(fos, new Adler32());
             ZipOutputStream zos =
                 new ZipOutputStream(new BufferedOutputStream(checksum))) {

            int size;
            byte[] buffer = new byte[1024];

            // Get all text files on the working folder.
            File dir = new File(".");
            String[] files = dir.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });

            for (String file : files) {
                System.out.println("Compressing: " + file);

                try (FileInputStream fis = new FileInputStream(file);
                     BufferedInputStream bis =
                         new BufferedInputStream(fis, buffer.length)) {

                    // put a new ZipEntry in the ZipOutputStream
                    ZipEntry zipEntry = new ZipEntry(file);
                    zos.putNextEntry(zipEntry);

                    // read data to the end of the source file and write it 
                    // to the zip output stream.
                    while ((size = bis.read(buffer, 0, buffer.length)) > 0) {
                        zos.write(buffer, 0, size);
                    }

                    zos.closeEntry();
                }
            }

            // Print out checksum value
            long value = checksum.getChecksum().getValue();
            System.out.println("Checksum   : " + value);
        }
    }
}
```
