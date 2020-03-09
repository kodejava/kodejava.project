package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class GettingScriptEngineByName {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();

        // Obtain an instance of ScriptEngine using the engine name. For
        // example we get a JavaScript ScriptEngine instance.
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            engine.eval("println('Hello World');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
