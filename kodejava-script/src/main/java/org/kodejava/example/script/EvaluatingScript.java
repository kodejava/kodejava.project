package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class EvaluatingScript {
    public static void main(String[] args) {
        // Obtaining JavaScript' ScriptEngine from the ScriptManager
        // using the engine extension.
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine js = manager.getEngineByExtension("js");

        try {
            // Evaluating a simple script
            js.eval("println('Hello World')");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
