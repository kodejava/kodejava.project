package org.kodejava.example.spring.singer;

public class AnySinger implements Singer {
    private String song = "Nana nana nana";
    private Instrument instrument = null;

    public AnySinger() {
    }

    /**
     * A constructor to create singer to sing a specific song.
     *
     * @param song the song title to sing.
     */
    public AnySinger(String song) {
        this.song = song;
    }

    /**
     * A constructor to create singer to sing a song while playing
     * an instrument.
     *
     * @param song the song title to sing.
     * @param instrument the instrument to play.
     */
    public AnySinger(String song, Instrument instrument) {
        this.song = song;
        this.instrument = instrument;
    }

    @Override
    public void sing() {
        System.out.println("Singing " + song);
        if (instrument != null) {
            instrument.play();
        }
    }
}
