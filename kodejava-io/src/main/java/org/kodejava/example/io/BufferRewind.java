package org.kodejava.example.io;

import java.nio.CharBuffer;

public class BufferRewind {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("The quick brown fox jumps over the lazy dog.");
        buffer.flip();

        // Read buffer's data using the get() method call.
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();

        // Rewind the buffer will set the position back to 0.
        // We rewind the buffer so that we can reread the buffer
        // data for another purposes.
        buffer.rewind();

        // Reread the buffer and append its data the a StringBuilder
        // object.
        StringBuilder bufferText = new StringBuilder();
        while (buffer.hasRemaining()) {
            bufferText.append(buffer.get());
        }
        System.out.println(bufferText);
    }
}
