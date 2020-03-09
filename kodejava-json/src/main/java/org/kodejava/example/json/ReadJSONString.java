package org.kodejava.example.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ReadJSONString {
    public static void main(String[] args) {
        // info.json
        // {
        //  "id": "1",
        //  "name": "Alice",
        //  "age": "20",
        //  "courses": [
        //    "Engineering",
        //    "Finance",
        //    "Chemistry"
        //  ]
        //}
        String resourceName = "/info.json";
        InputStream is = ReadJSONString.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        System.out.println("Id  : " + object.getLong("id"));
        System.out.println("Name: " + object.getString("name"));
        System.out.println("Age : " + object.getInt("age"));

        System.out.println("Courses: ");
        JSONArray courses = object.getJSONArray("courses");
        for (int i = 0; i < courses.length(); i++) {
            System.out.println("  - " + courses.get(i));
        }
    }
}
