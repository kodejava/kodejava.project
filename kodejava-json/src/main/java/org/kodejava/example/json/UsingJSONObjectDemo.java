package org.kodejava.example.json;

import org.json.JSONObject;

public class UsingJSONObjectDemo {
    public static void main(String[] args) {
        JSONObject one = new JSONObject();
        one.put("One", "One");
        one.append("number", 1);
        one.append("number", 2);
        one.append("number", 3);
        one.accumulate("number", 4);

        System.out.println(one.toString());
    }
}
