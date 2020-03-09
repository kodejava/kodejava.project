# How do I create a zip file?

```java
package org.kodejava.example.zip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZippingFileExample {
    public static void main(String[] args) {
        String source = "data.txt";
        String target = "data.zip";

        try (ZipOutputStream zos = 
                 new ZipOutputStream(new FileOutputStream(target));
             InputStream is = 
                 ZippingFileExample.class.getResourceAsStream("/" + source)) {

            // Put a new ZipEntry in the ZipOutputStream
            zos.putNextEntry(new ZipEntry(source));

            int size;
            byte[] buffer = new byte[1024];

            // Read data to the end of the source file and write it
            // to the zip output stream.
            while ((size = is.read(buffer, 0, buffer.length)) > 0) {
                zos.write(buffer, 0, size);
            }

            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
