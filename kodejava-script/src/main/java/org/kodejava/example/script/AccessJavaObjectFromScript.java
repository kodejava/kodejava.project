package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Date;

public class AccessJavaObjectFromScript {
    public static void main(String[] args) {
        // Creating an array of five colors
        String[] colors = {"White", "Black", "Red", "Green", "Blue"};
        Date now = new Date();

        // Below is our script to read the values of Java array that
        // contains string of colors.
        String script =
            "var index; " +
                "var colors = colorArray; " +
                " " +
                "for (index in colors) { " +
                "    println(colors[index]); " +
                "}" +
                "println('----------'); " +
                "println('Today is ' + date); ";

        // Obtain a ScriptEngine instance.
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        // Place the colors array into the engine using colorArray key.
        // After setting the array into the engine our script will be
        // able to read it.
        engine.put("colorArray", colors);
        engine.put("date", now);

        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
