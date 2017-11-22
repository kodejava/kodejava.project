package org.kodejava.example.awt;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class ToneUtils {
    public static final float SAMPLE_RATE = 10000f;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            tone(400, 500, 0.5);
            Thread.sleep(250);
        }
    }

    private static void tone(int frequency, int milliseconds) throws LineUnavailableException  {
        tone(frequency, milliseconds, 1);
    }

    private static void tone(int frequency, int milliseconds, double volume) throws LineUnavailableException {
        byte[] buffer = new byte[1];
        AudioFormat audioFormat = new AudioFormat(
            SAMPLE_RATE,
            8,
            1,
            true,
            false);

        SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(audioFormat);
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();

        for (int i = 0; i < milliseconds * 8; i++) {
            double angle = i / (SAMPLE_RATE / frequency) * 2.0 * Math.PI;
            buffer[0] = (byte) (Math.sin(angle) * 127.0 * volume);
            sourceDataLine.write(buffer, 0, 1);
        }

        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
    }
}
