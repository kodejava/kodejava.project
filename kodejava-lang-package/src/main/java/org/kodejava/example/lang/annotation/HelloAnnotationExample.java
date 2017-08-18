package org.kodejava.example.lang.annotation;

@HelloAnnotation(value = "Good Morning", greetTo = "Universe")
public class HelloAnnotationExample {
    public static void main(String[] args) {
        HelloAnnotationExample anno = new HelloAnnotationExample();
        anno.sayHi();
        anno.sayHello();
    }

    @HelloAnnotation(value = "Hi there", greetTo = "Alice")
    public void sayHi() {
    }

    @HelloAnnotation(value = "Hello there", greetTo = "Bob")
    public void sayHello() {
    }
}
