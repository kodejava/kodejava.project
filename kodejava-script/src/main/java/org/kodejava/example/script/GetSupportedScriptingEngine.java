package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngineFactory;
import java.util.List;

public class GetSupportedScriptingEngine {
    public static void main(String[] args) {
        // Creating an instance of ScriptEngineManager an get the list
        // of available ScriptEngineFactory.
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();

        for (ScriptEngineFactory factory : factories) {
            System.out.println(
                "EngineName      = " + factory.getEngineName());
            System.out.println(
                "EngineVersion   = " + factory.getEngineVersion());
            System.out.println(
                "LanguageName    = " + factory.getLanguageName());
            System.out.println(
                "LanguageVersion = " + factory.getLanguageVersion());
            System.out.println(
                "Extensions      = " + factory.getExtensions());

            List<String> names = factory.getNames();
            for (String name : names) {
                System.out.println("Engine Alias = " + name);
            }
        }
    }
}
