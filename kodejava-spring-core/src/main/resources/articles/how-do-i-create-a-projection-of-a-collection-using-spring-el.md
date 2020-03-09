# How do I create a projection of a collection using Spring EL?

In this example you will learn how to create a projection of a collection object. Using projection we can create a new collection with only a specific property from the original collection.

As an example, instead of returning a collection of `Book` objects we would like only to have the titles of the books. To do this we can use the Spring EL projection operator. The symbol use for this operator is `![]`.

Let's begin by creating the Spring configuration file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <util:list id="books">
        <bean class="org.kodejava.example.spring.el.Book"
              p:title="Essential C# 4.0" p:author="Michaelis" p:pages="450"/>
        <bean class="org.kodejava.example.spring.el.Book"
              p:title="User Stories Applied" p:author="Mike Cohen" p:pages="268"/>
        <bean class="org.kodejava.example.spring.el.Book"
              p:title="Learning Android" p:author="Marco Gargenta" p:pages="245"/>
        <bean class="org.kodejava.example.spring.el.Book"
              p:title="The Ruby Programming Language"
              p:author="David Flanagan &amp; Yukihiro Matsumoto" p:pages="250"/>
        <bean class="org.kodejava.example.spring.el.Book"
              p:title="Einstein" p:author="Walter Isaacson" p:pages="1000"/>
    </util:list>

    <bean id="library" class="org.kodejava.example.spring.el.Library">
        <property name="bookTitles" value="#{books.![title]}"/>
    </bean>

</beans>
```

Here are the definition of the `Book` and `Library` class. The getters and setters methods were removed for simplicity of the snippet.

```java
package org.kodejava.example.spring.el;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String type;
    private int pages;

    // Getters & Setters
}
```

```java
package org.kodejava.example.spring.el;

import java.util.List;

public class Library {
    private List<Book> books;
    private List<String> bookTitles;

    // Getters & Setters
}
```

Now, let's talk about the Spring configuration above. The configuration was start by creating a collection of Books using the `<util:elements>`. The part that use the projection operator is this part of the configuration:

```xml
<bean id="library" class="org.kodejava.example.spring.model.Library">
    <property name="bookTitles" value="#{books.![title]}"/>
</bean>
```

The `bean` element above create a `library` bean of type `org.kodejava.example.spring.model.Library`. We assign the bean's `bookTitles` property with values that are a projection of the +books+ collection where we take only the title of the books. `![projectionExpression]` is the syntax of the projection operator.

The code snippet below will demonstrate and run our configuration file and print out the result:

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELProjectionExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-projection.xml");

        Library library = context.getBean("library", Library.class);

        for (String title : library.getBookTitles()) {
            System.out.println("title = " + title);
        }
    }
}
```

And here are the result:

```text
title = Essential C# 4.0
title = User Stories Applied
title = Learning Android
title = The Ruby Programming Language
title = Einstein
```
