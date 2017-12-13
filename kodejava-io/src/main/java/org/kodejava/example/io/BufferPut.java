package org.kodejava.example.io;

import java.nio.ByteBuffer;

public class BufferPut {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put((byte) 65);
        buffer.put((byte) 66);
        buffer.put((byte) 67);
        buffer.put((byte) 68);
        buffer.put((byte) 69);


        // Writes a sequence of bytes
        byte[] bytes = new byte[] {70, 71, 72, 73, 74};
        buffer.put(bytes);

        // Write to the beginning of the buffer
        buffer.put(0, (byte) 75);

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
    }
}
