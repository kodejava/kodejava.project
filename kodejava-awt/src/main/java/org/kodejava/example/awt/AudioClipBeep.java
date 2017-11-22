package org.kodejava.example.awt;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AudioClipBeep {
    public static void main(String[] args) {
        URL url = AudioClipBeep.class.getResource("/beep.wav");
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
    }
}
