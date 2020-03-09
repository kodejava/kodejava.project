# How do I filter collection members based on some criteria using Spring EL?

In some of the previous example you have seen that we use the square-braces `[]` operator to select items from collection. In this blog post you will learn how to filter some members of a collection with a certain criteria while using the Spring EL. To do this Spring EL give you another special operator, the filter operator which can be typed like `.?[]`. Where you can define the filter criteria inside the braces.

Beside the filter operator `.?[]>` there are also operator that can select the first and the last matching items from collection. You can use the `.^[]` for selecting the first match and the `.$[]` operator to select the last match items from collection respectively.

As an example we will demonstrate here that we want to find a collection of books that have pages more than 250 and assign it to `Library` bean’s `books` properties. So let’s begin by defining a class called `Book` and `Library` which will have the following properties:

```java
package org.kodejava.example.spring.el;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String type;
    private int pages;

    // Getters & Setters

    @Override
    public String toString() {
        return "Book{" +
            "title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", pages=" + pages +
            '}';
    }
}
```

```java
package org.kodejava.example.spring.el;

import java.util.List;

public class Library {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
```

After creating the `Book` and the `Library` class let’s now create the Spring configuration file for our demo. We will create a file and call it as `spel-select-collection.xml` with the following lines of configuration in it.

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

    <bean id="lib1" class="org.kodejava.example.spring.el.Library">
        <property name="books" value="#{books.?[pages gt 250]}"/>
    </bean>

    <bean id="lib2" class="org.kodejava.example.spring.el.Library">
        <property name="books" value="#{books.^[pages gt 250]}"/>
    </bean>

    <bean id="lib3" class="org.kodejava.example.spring.el.Library">
        <property name="books" value="#{books.$[pages gt 250]}"/>
    </bean>

</beans>
```

The first thing that you can see in the configuration above is the `<util-list>` where we create a list of `Book` beans. Next we have three beans definition of the type `Library` where the `books` property was assigned with a collection of beans selected from the `books` list.

The `lib1` will contains books that have pages more than 250. The `lib2` will contains the first book found to have more than 250 pages while the `lib3` will contains the last book found to have more than 250 pages.

Below is the code that will run our configuration file and the example output it will produce.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELFilterCollection {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-filter-collection.xml");

        System.out.println("Library 1");
        Library lib1 = (Library) context.getBean("lib1");
        for (Book book : lib1.getBooks()) {
            System.out.println("    Book = " + book);
        }

        System.out.println("Library 2");
        Library lib2 = (Library) context.getBean("lib2");
        for (Book book : lib2.getBooks()) {
            System.out.println("    Book = " + book);
        }

        System.out.println("Library 3");
        Library lib3 = (Library) context.getBean("lib3");
        for (Book book : lib3.getBooks()) {
            System.out.println("    Book = " + book);
        }
    }
}
```

```text
Library 1
    Book = Book{title='Essential C# 4.0', author='Michaelis', pages=450}
    Book = Book{title='User Stories Applied', author='Mike Cohen', pages=268}
    Book = Book{title='Einstein', author='Walter Isaacson', pages=1000}
Library 2
    Book = Book{title='Essential C# 4.0', author='Michaelis', pages=450}
Library 3
    Book = Book{title='Einstein', author='Walter Isaacson', pages=1000}
```
