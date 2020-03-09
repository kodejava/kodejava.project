# How do I access Map element using Spring EL?

In the previous example, [How do I access collections members using Spring EL?](//kodejava.org/how-do-i-access-collections-members-using-spring-el/), you have seen how to access a member of a collection using Spring EL square-braces `[]` operator. In this post you will learn how to use the same operator to access an element of a Map object.

For demonstration we will use the same `Book` class in the previous example to create the bean. The class without the corresponding getters and setters is as follow:

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

Next, let’s create the spring configuration file. In this configuration file we create a map using the `<util:map>` with the map id of `books` and add some key-value pair entries in the map.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <util:map id="books">
        <entry key="0-201-61622-X" value="The Pragmatic Programmer"/>
        <entry key="978-1-934356-56-2" value="Hello, Android"/>
        <entry key="978-1-933988-69-6" value="Secret of The JavaScript Ninja"/>
        <entry key="978-1-449-37017-6" value="Java EE 7 Essentials"/>
        <entry key="9781935182962" value="Spring Roo in Action"/>
    </util:map>

    <bean id="book1" class="org.kodejava.example.spring.el.Book"
          p:title="#{books['9781935182962']}"/>
    <bean id="book2" class="org.kodejava.example.spring.el.Book"
          p:title="#{books['978-1-933988-69-6']}"/>

</beans>
```

After defining the map you can see how we access an element of the map. We use the square-braces operator `[]`, we use the same operator as we are accessing a collection member. But instead of passing the index to the operator we pass the key of the map element that we are going to read.

```xml
<bean id="book2" class="org.kodejava.example.spring.model.Book" p:title="#{books['978-1-933988-69-6']}"/>
```

Finally to run the configuration you’ll need to create the following class:

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELMapExample {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-map.xml");

        Book book1 = (Book) context.getBean("book1");
        Book book2 = (Book) context.getBean("book2");

        System.out.println("book1.getTitle() = " + book1.getTitle());
        System.out.println("book2.getTitle() = " + book2.getTitle());
    }
}
```

And example of output produced by this code can be seen below:

```text
book1.getTitle() = Spring Roo in Action
book2.getTitle() = Secret of The JavaScript Ninja
```
