package org.kodejava.example.io;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferRead {
    public static void main(String[] args) throws Exception {
        FileChannel channel = null;

        try {
            // Define an output file and create an instance of FileOutputStream
            File file = new File("result.txt");
            FileOutputStream fos = new FileOutputStream(file);

            // Create a dummy ByteBuffer which value to be read into a channel.
            ByteBuffer buffer = ByteBuffer.allocate(256);
            buffer.put(new byte[] {65, 66, 67, 68, 69, 70, 71, 72, 73, 74});

            // Change the buffer from writing mode to reading mode.
            buffer.flip();

            // Gets the channel from the FileOutputStream object and read the
            // data available in buffer using channel.write() method.
            channel = fos.getChannel();
            int bytesWritten = channel.write(buffer);
            System.out.println("written : " + bytesWritten);
        } finally {
            if (channel != null && channel.isOpen()) {
                channel.close();
            }
        }
    }
}
