package org.kodejava.example.lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HelloAnnotation {
    String value();
    String greetTo();
}
