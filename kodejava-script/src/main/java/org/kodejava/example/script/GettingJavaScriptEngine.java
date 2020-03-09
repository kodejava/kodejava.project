package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class GettingJavaScriptEngine {
    public static void main(String[] args) {
        // Creating an instance of ScriptManager. With ScriptManager in hand we
        // can create an interpreter or ScriptEngine to run JavaScript.
        ScriptEngineManager manager = new ScriptEngineManager();

        // Calling manager.getEngineByExtension("js") returns a ScriptEngine
        // implementation for JavaScript. "js" is the standard extension for
        // JavaScript script file.
        ScriptEngine engine = manager.getEngineByExtension("js");

        // Do something with the script engine.
    }
}
