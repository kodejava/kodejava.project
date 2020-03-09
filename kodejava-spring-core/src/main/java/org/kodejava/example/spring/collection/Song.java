package org.kodejava.example.spring.collection;

public class Song {
    private String title;
    private String writer;

    public Song() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Song{" +
            "title='" + title + '\'' +
            ", writer='" + writer + '\'' +
            '}';
    }
}
