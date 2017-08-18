package org.kodejava.example.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GetAllAnnotation {
    private Map<String, String> data = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        GetAllAnnotation demo = new GetAllAnnotation();
        demo.sayHi("001", "Alice");
        demo.sayHi("004", "Malory");

        try {
            Class clazz = demo.getClass();

            // To get the sayHi() method we need to pass not only the method
            // name but also its parameters type so the the getMethod() method
            // return the correct method for us to use.
            Method method = clazz.getMethod("sayHi", String.class, String.class);

            // Get all annotations from the sayHi() method. But this actually
            // will only return one annotation. Because only the HelloAnnotation
            // annotation that has RUNTIME retention policy, which means that
            // the other annotations associated with sayHi() method is not
            // available at runtime.
            Annotation[] annotations = method.getAnnotations();
            for (Annotation anno : annotations) {
                System.out.println("Type: " + anno.annotationType());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @MyAnnotation("Hi")
    @HelloAnnotation(value = "Hello", greetTo = "Everyone")
    public void sayHi(String dataId, String name) {
        Map data = getData();
        if (data.containsKey(dataId)) {
            System.out.println("Hello " + data.get(dataId));
        } else {
            data.put(dataId, name);
        }
    }

    private Map<String, String> getData() {
        data.put("001", "Alice");
        data.put("002", "Bob");
        data.put("003", "Carol");
        return data;
    }
}
