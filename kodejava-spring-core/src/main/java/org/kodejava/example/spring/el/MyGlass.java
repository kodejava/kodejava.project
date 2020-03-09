package org.kodejava.example.spring.el;

public class MyGlass {
    private boolean empty;
    private boolean halfEmpty;
    private int volume;
    private int maxVolume;

    public MyGlass() {
    }

    public MyGlass(int volume, int maxVolume) {
        this.volume = volume;
        this.maxVolume = maxVolume;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isHalfEmpty() {
        return halfEmpty;
    }

    public void setHalfEmpty(boolean halfEmpty) {
        this.halfEmpty = halfEmpty;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }
}
