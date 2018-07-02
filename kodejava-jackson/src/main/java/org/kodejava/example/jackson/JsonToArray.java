package org.kodejava.example.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToArray {
    public static void main(String[] args) {
        String jsonArray = "[{\"title\":\"Java in Action\"}, {\"title\":\"Spring in Action\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Book[] books = objectMapper.readValue(jsonArray, Book[].class);
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
