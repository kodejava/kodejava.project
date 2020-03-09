# How do I use ternary operator in Spring EL?

In this example you will learn how to use ternary operator in Spring Expression Language. The ternary operator will evaluate a Spring EL to one value if a condition is `true` and to another value if the condition is `false`. Ternary operator is written using the `?:` symbols, just as what you do in Java. The test condition is placed on the left side of the `?` symbol while the evaluating expression is placed between the `:` symbol.

As an example let's see how to use the ternary operator in a spring configuration file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="book1" class="org.kodejava.example.spring.el.Book">
        <property name="type" value="Novel"/>
    </bean>
    <bean id="book2" class="org.kodejava.example.spring.el.Book">
        <property name="type" value="#{book1.type != null ? book1.type : 'Novel'}"/>
    </bean>
    <bean id="book3" class="org.kodejava.example.spring.el.Book">
        <property name="type" value="#{book1.type ?: 'Novel'}"/>
    </bean>

</beans>
```

In the configuration you'll see that there are two way to use the operator. On the `book2` bean we use the common usage of the operator. We check if the `book1.type` is not equal to null, if this is true then we take the `book1.type` as the value otherwise we just assign the type to `'Novel'`.

There are some duplication in the first example. As you can see we call the boo1.type twice in that line of code. Actually the Spring EL version can give you a shorter one. Instead of doing like before you can just use the ternary operator like what we use in the `book3` bean. So we can type `book1.type ?: 'Novel'`. Which will give us the same result.

Having the configuration created you will also need the `Book` class. So here is the `Book` class definition.

```java
package org.kodejava.example.spring.el;

public class Book {
    private String type;

    public Book() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
```

Finally let's now create a class to run the spring configuration. This class basically just load the spring configuration file `spel-ternary.xml` and get some beans, the `Book` bean from the application context and print out the value of its `type` property.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELTernaryOperatorExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-ternary.xml");

        Book book1 = (Book) context.getBean("book1");
        Book book2 = (Book) context.getBean("book2");
        Book book3 = (Book) context.getBean("book3");

        System.out.println("book1.getType() = " + book1.getType());
        System.out.println("book2.getType() = " + book2.getType());
        System.out.println("book3.getType() = " + book3.getType());

    }
}
```

And here are the execution output that you'll get.

```text
book1.getType() = Novel
book2.getType() = Novel
book3.getType() = Novel
```
