package org.kodejava.example.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class WriteJSONString {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("id", 1L);
        object.put("name", "Alice");
        object.put("age", 20);

        JSONArray courses = new JSONArray();
        courses.put("Engineering");
        courses.put("Finance");
        courses.put("Chemistry");

        object.put("courses", courses);

        String jsonString = object.toString(2);
        System.out.println(jsonString);
    }
}
