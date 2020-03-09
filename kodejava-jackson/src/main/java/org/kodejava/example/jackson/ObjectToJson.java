package org.kodejava.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
    public static void main(String[] args) {
        Artist artist = new Artist();
        artist.setId(1L);
        artist.setName("The Beatles");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(artist);
            System.out.println("JSON = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
