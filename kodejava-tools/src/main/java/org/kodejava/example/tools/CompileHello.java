package org.kodejava.example.tools;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class CompileHello {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null,
            "kodejava-tools/src/main/java/org/kodejava/example/tools/Hello.java");

        System.out.println("Compile result code = " + result);
    }
}
