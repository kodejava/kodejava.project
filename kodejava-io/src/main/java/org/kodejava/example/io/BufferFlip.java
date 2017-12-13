package org.kodejava.example.io;

import java.nio.CharBuffer;

public class BufferFlip {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(1024);
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit    = " + buffer.limit());

        buffer.put("Java NIO Programming");

        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit    = " + buffer.limit());

        buffer.flip();
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit    = " + buffer.limit());
    }
}
