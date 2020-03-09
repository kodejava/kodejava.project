# How do I combine filter and projection operation in Spring EL?

Using Spring Expression Language (SpEL) we can filter a collection based on some criteria. We can also create a projection of a collection by collecting only a particular property from the collection objects.

Now you know that you have two good features of SpEL that are really powerful to use when working with collection objects manipulation. But you are wondering how to combine both of these filter and projection in one expression. Can you do this in Spring EL? The answer is yes! You can combine them both in one expression. Let's see an example below.

We are going to use the same configuration used in the previous example:
 
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
        <property name="bookTitles" value="#{books.?[pages gt 250].![title]}"/>
    </bean>

</beans>
``` 

In the configuration above, when we define the `library` bean we set its `bookTitles` property using the filtering and projection operator. First we take only books that have more that 250 pages and then we create the projection that contains only the book title. So this expression give us all the book's title of a book that has more than 250 pages.

To make the example complete here again the definition of the `Book` and the `Library` class.
 
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

The main class the run the configuration file:
 
```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELFilterProjectionExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-filter-projection.xml");

        Library library = context.getBean("library", Library.class);

        for (String title : library.getBookTitles()) {
            System.out.println("title = " + title);
        }
    }
}
``` 

The result of the code snippet:

 
```text
title = Essential C# 4.0
title = User Stories Applied
title = Einstein
``` 
