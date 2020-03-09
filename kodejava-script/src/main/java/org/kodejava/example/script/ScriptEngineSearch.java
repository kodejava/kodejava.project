package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.List;

public class ScriptEngineSearch {
    public static void main(String[] args) {
        String languageName = "ECMAScript";
        String languageVersion = "1.8";

        // Creating a ScriptEngineManager and get the list of available
        // engine factories.
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();

        // We obtain a ScriptEngine from the available factories where
        // the language name is ECMAScript and the version is 1.6.
        // ECMAScript is the standard name for JavaScript programming
        // language. If we found the desired language we then get the
        // ScriptEngine by calling factory's getScriptEngine() method.
        ScriptEngine engine = null;
        for (ScriptEngineFactory factory : factories) {
            String language = factory.getLanguageName();
            String version = factory.getLanguageVersion();

            if (language.equals(languageName)
                && version.equals(languageVersion)) {
                engine = factory.getScriptEngine();
                break;
            }
        }

        if (engine != null) {
            try {
                engine.eval("print('Hello There')");
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }
}
