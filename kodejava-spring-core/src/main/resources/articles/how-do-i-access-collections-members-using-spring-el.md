# How do I access collections members using Spring EL?

In this post you will see another powerful examples of Spring EL. We are going to demonstrate how to use Spring EL to access collection members.

By using Spring EL you can select a single reference member of a collection. You can also select members of collection based on the values of their properties. Another thing you can do is extract properties out of the collection members to create another collection object.

To demonstrate this we are going to create a simple bean / pojo as our collection object. We will create a Book class with some properties (`id`, `title`, `author`).

```java
package org.kodejava.example.spring.el;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String type;

    // Getters & Setters
}
```

Next, we need to create the spring configuration file. In this configuration we will create a collection of books using the `<util:list>` element. And we also create a bean with its properties is obtained from one of the collection objects.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <util:list id="books">
        <bean class="org.kodejava.example.spring.model.Book"
                p:title="Essential C# 4.0" p:author="Michaelis"/>
        <bean class="org.kodejava.example.spring.model.Book"
              p:title="User Stories Applied" p:author="Mike Cohen"/>
        <bean class="org.kodejava.example.spring.model.Book"
              p:title="Learning Android" p:author="Marco Gargenta"/>
        <bean class="org.kodejava.example.spring.model.Book"
              p:title="The Ruby Programming Language"
              p:author="David Flanagan &amp; Yukihiro Matsumoto"/>
        <bean class="org.kodejava.example.spring.model.Book"
              p:title="Einstein" p:author="Walter Isaacson"/>
    </util:list>

    <bean id="book" class="org.kodejava.example.spring.model.Book">
        <property name="title" value="#{books[3].title}"/>
        <property name="author" value="#{books[3].author}"/>
    </bean>
    
</beans>
```

In the configuration above you have seen how we set the `title` and `author` of the `book` bean. We use the square-braces operator (`[]`) to access collection's member by their index. It's look like this:

```xml
<property name="title" value="#{books[3].title}"/>
<property name="author" value="#{books[3].author}"/>
```

Which can be read as: please give me the collection object at index number `3` and take the value of its `title` and `author` to be assigned to the `book` bean. And as you might already know that a collection object in Java is always zero-based index. So this will give us the book with title _"The Ruby Programming Language"_.

And finally let’s create an example class that run our spring configuration above. It’s simply load the `spell-collection.xml` configuration we create above. Get a bean from the loaded `ApplicationContext` and print out its properties, `title` and `author` properties.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELCollectionExample {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spel-collection.xml");

        Book book = (Book) context.getBean("book");
        System.out.println("book.getTitle() = " + book.getTitle());
        System.out.println("book.getAuthor() = " + book.getAuthor());
    }
}
```

Executing the code above will give you the following result:

```text
book.getTitle() = The Ruby Programming Language
book.getAuthor() = David Flanagan & Yukihiro Matsumoto
```
