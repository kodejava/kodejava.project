# How do I inject into bean properties?

A bean usually have some private properties that can be accessed through a pair of accessor methods, the setters and getters. This setters, the `setXXX()` method can be used by Spring framework to configure the beans.

This method of injecting beans property through their setter methods is called the setter injection. The following example will show you how to do it.

Below is our `DrawingBean` that have colour and shape properties. In the example we will inject both of the properties using their respective setter method. This configuration is done in the Spring application configuration file.

```java
package org.kodejava.example.spring.inject;

public class DrawingBean {
    private String colour;
    private Shape shape;

    public DrawingBean() {
    }

    public void drawShape() {
        getShape().draw();
        System.out.printf("The colour is %s.", getColour());
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
```

We can inject a simple value into a bean, such as string, number, etc. We can also inject a reference to another bean. Here we define an example of other bean, the `Rectangle` bean that we will inject into the `DrawingBean`.

```java
package org.kodejava.example.spring.inject;

public interface Shape {
    /**
     * Draw a shape.
     */
    void draw();
}
```

```java
package org.kodejava.example.spring.inject;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}
```

Let's create the Spring application configuration file that will register our beans into the Spring context. After that we just create a simple program to execute it.


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="rectangle" class="org.kodejava.example.spring.inject.Rectangle"/>

    <bean id="drawingBean" class="org.kodejava.example.spring.inject.DrawingBean">
        <property name="colour" value="Red"/>
        <property name="shape" ref="rectangle"/>
    </bean>
    
</beans>
```

In the configuration file above you can see that we use the `property` element to set a bean's property. The `name` attribute is referring to the bean's setter methods name, exclude the `set` prefix.

The `value` attribute of the `property` element is used to inject a simple value, such as string, int, etc. For injecting a reference to another bean we use the `ref` attribute instead.

```java
package org.kodejava.example.spring.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingBeanDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"drawing-bean.xml"});
        DrawingBean bean = (DrawingBean) context.getBean("drawingBean");
        bean.drawShape();
    }
}
```

Here are the output of our example:

```text
Drawing a rectangle.
The colour is Red.
```
