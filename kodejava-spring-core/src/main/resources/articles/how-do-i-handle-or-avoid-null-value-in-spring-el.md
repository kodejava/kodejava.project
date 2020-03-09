# How do I handle or avoid null value in Spring EL?

In this example you will learn how to avoid a null value, which causing a `NullPointerException` thrown in a Spring EL expression. To avoid this from happening we can use the null-safe accessor, using the `?.` operator.

We are using the previous example, [How do I inject bean's property using Spring EL?](//kodejava.org/how-do-i-inject-beans-properties-and-methods-using-spring-el/) classes, which are the `Student` class and the `Grade` class. What we need is to create a new spring configuration file to demonstrate this feature. So, here is the configuration file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="student" class="org.kodejava.example.spring.el.Student">
        <property name="name" value="Alice"/>
        <property name="grade" value="#{grade.getName()?.toUpperCase()}"/>
    </bean>

    <bean id="grade" class="org.kodejava.example.spring.el.Grade">
        <property name="name">
            <null/>
        </property>
        <property name="description" value="A beginner grade."/>
    </bean>

</beans>
```

The use of null-safe accessor can be seen on the `student` bean's `grade` property. We are calling the `grade.getName()` method and convert it to uppercase. We deliberately set the `grade.name` property to `null`. Calling `toUpperCase` on a `null` value will throw the `NullPointerException`. But because we are using the null-safe accessor the exception is not thrown, because the expression will not execute the code after the null-safe accessor. In this case when `getName()` return `null`, the `toUpperCase()` method will never get called.

Below is the demo program code:

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELNullSafeExpressionDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spel-null-safe.xml");

        Student student = (Student) context.getBean("student");
        System.out.println("Name  = " + student.getName());
        System.out.println("Grade = " + student.getGrade());
    }
}
```

Here is the result of the code:

```text
Name  = Alice
Grade = null
```
