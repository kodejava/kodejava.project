package org.kodejava.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class CopyFileExample {
    public static void main(String[] args) throws Exception {
        String source = "medical-report.txt";
        String destination = "medical-report-final.txt";

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);

        FileChannel inputChannel = fis.getChannel();
        FileChannel outputChannel = fos.getChannel();

        // Create a buffer with 1024 size for buffering data
        // while copying from source file to destination file.
        // To create the buffer here we used a static method
        // ByteBuffer.allocate()
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Here we start to read the source file and write it
        // to the destination file. We repeat this process
        // until the read method of input stream channel return
        // nothing (-1).
        while (true) {
            // Read a block of data and put it in the buffer
            int read = inputChannel.read(buffer);

            // Did we reach the end of the channel? if yes
            // jump out the while-loop
            if (read == -1) {
                break;
            }

            // flip the buffer
            buffer.flip();

            // write to the destination channel and clear the buffer.
            outputChannel.write(buffer);
            buffer.clear();
        }
    }
}
