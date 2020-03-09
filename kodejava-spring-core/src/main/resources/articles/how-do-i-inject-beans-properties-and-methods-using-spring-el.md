# How do I inject beans, properties and methods using Spring EL?

Using Spring Expression Language (SpEL) we can inject object references or values into a bean dynamically when the bean is created instead of statically defined at development time. In this example you'll learn how to inject a bean's property using a property of another bean.

Let start by create two classes, the `Student` and `Grade` classes. The student object will have a property to store their grade name which will be obtained from the grade object.

```java
package org.kodejava.example.spring.el;

public class Student {
    private String name;
    private String grade;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
```

```java
package org.kodejava.example.spring.el;

public class Grade {
    private String name;
    private String description;

    public Grade() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
```

Next we create the spring configuration file. In this configuration we have two beans definition, the `grade` and `student` bean. We set the `name` and `description` property of the `grade` bean.

We also set the name property of `student` bean using a string literal. But the `grade` property value is set to the `grade`'s bean name property using the Spring EL, `#{grade.name}`. The expression tells the spring container to look for a bean whose id is `grade`, read its `name` and assign it to `student`'s grade.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="grade" class="org.kodejava.example.spring.el.Grade">
        <property name="name" value="Beginner"/>
        <property name="description" value="A beginner grade."/>
    </bean>
    <bean id="student" class="org.kodejava.example.spring.el.Student">
        <property name="name" value="Alice"/>
        <property name="grade" value="#{grade.name}"/>
    </bean>

</beans>
```

And then create the following program to execute the spring container and retrieve the student bean from it.

```java
package org.kodejava.example.spring.el;

import org.kodejava.example.spring.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spel-example.xml");

        Student student = (Student) context.getBean("student");
        System.out.println("Name  = " + student.getName());
        System.out.println("Grade = " + student.getGrade());
    }
}
```

This program will print the following output:

```text
Name  = Alice
Grade = Beginner
```
