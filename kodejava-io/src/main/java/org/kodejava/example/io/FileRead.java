package org.kodejava.example.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileRead {
    public static void main(String[] args) {
        String path = "D:/Temp/source.txt";
        try (FileInputStream fis = new FileInputStream(path);
             FileChannel fileChannel = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(64);

            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }

                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
