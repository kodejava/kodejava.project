package org.kodejava.example.io;

import java.nio.*;

public class BufferAllocate {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        CharBuffer charBuffer = CharBuffer.allocate(64);
        ShortBuffer shortBuffer = ShortBuffer.allocate(64);
        IntBuffer intBuffer = IntBuffer.allocate(64);
        LongBuffer longBuffer = LongBuffer.allocate(64);
        FloatBuffer floatBuffer = FloatBuffer.allocate(64);
        DoubleBuffer doubleBuffer = DoubleBuffer.allocate(64);
    }
}
