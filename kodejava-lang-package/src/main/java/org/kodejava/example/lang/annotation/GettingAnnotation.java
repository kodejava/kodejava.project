package org.kodejava.example.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@HelloAnnotation(value = "Hello", greetTo = "Universe")
public class GettingAnnotation {
    public static void main(String[] args) {
        GettingAnnotation demo = new GettingAnnotation();

        Class clazz = demo.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println("Annotation Type: " + anno.annotationType());
        }

        HelloAnnotation anno = (HelloAnnotation) clazz.getAnnotation(HelloAnnotation.class);
        System.out.println("Anno Value  : " + anno.value());
        System.out.println("Anno GreetTo: " + anno.greetTo());

        try {
            Method m = clazz.getMethod("sayHi");

            anno = m.getAnnotation(HelloAnnotation.class);
            System.out.println("Anno Value  : " + anno.value());
            System.out.println("Anno GreetTo: " + anno.greetTo());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        demo.sayHello();
    }

    @HelloAnnotation(value = "Hi", greetTo = "Alice")
    public void sayHi() {
    }

    @HelloAnnotation(value = "Hello", greetTo = "Bob")
    public void sayHello() {
        try {
            Method m = getClass().getMethod("sayHello");
            HelloAnnotation anno = m.getAnnotation(HelloAnnotation.class);

            System.out.println(anno.value() + " " + anno.greetTo());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
