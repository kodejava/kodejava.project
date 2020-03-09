package org.kodejava.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.Month;

public class RecordingToJson {
    public static void main(String[] args) {
        Recording recording = new Recording();
        recording.setId(1L);
        recording.setTitle("Twist and Shout");
        recording.setReleaseDate(LocalDate.of(1964, Month.FEBRUARY, 3));

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(recording);
            System.out.println("JSON = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
