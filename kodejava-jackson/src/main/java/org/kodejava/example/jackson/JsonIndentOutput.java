package org.kodejava.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class JsonIndentOutput {
    public static void main(String[] args) {
        JsonIndentOutput.formatObjectToJsonString();
        JsonIndentOutput.formatJsonString();
    }

    private static void formatObjectToJsonString() {
        Recording recording = new Recording();
        recording.setId(1L);
        recording.setTitle("Yellow Submarine");
        recording.setReleaseDate(LocalDate.of(1969, Month.JANUARY, 17));
        recording.setArtist(new Artist(1L, "The Beatles"));
        recording.setLabel(new Label(1L, "Apple"));

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(recording);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static void formatJsonString() {
        String json = "{\"id\":1,\"title\":\"Yellow Submarine\",\"releaseDate\":\"1969-01-17\",\"artist\":{\"id\":1,\"name\":\"The Beatles\"},\"label\":{\"id\":1,\"name\":\"Apple\"}}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object jsonObject = mapper.readValue(json, Object.class);
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            System.out.println(prettyJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
