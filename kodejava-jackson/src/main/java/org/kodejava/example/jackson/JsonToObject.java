package org.kodejava.example.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToObject {
    public static void main(String[] args) {
        String json = "{\"id\": 1, \"name\": \"The Beatles\"}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            Artist artist = mapper.readValue(json, Artist.class);
            System.out.println("Artist = " + artist);

            System.out.println("artist.getId() = " + artist.getId());
            System.out.println("artist.getName() = " + artist.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
