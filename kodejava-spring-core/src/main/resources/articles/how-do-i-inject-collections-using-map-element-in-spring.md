# How do I inject collections using map element in Spring?

In this example you will see how to wire map collections. For this purpose we can use the `<map>` element in the Spring configuration file. This element declares the `java.util.Map`. We will reuse the bean that we use in the previous example [How do I inject collections using list element in Spring?](//kodejava.org/how-do-i-inject-collections-using-list-element-in-spring/).

The `<map>` element can have many `<entry>` element with the `key` and `value-ref` attribute.

Here is the configuration example:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="song1" class="org.kodejava.example.spring.collection.Song">
        <property name="title" value="I Saw Her Standing There" />
        <property name="writer" value="Beatles" />
    </bean>

    <bean id="song2" class="org.kodejava.example.spring.collection.Song">
        <property name="title" value="Misery" />
        <property name="writer" value="Beatles" />
    </bean>

    <bean id="song3" class="org.kodejava.example.spring.collection.Song">
        <property name="title" value="Anna (Go to Him)" />
        <property name="writer" value="Beatles" />
    </bean>

    <bean id="publisher" class="org.kodejava.example.spring.collection.Publisher">
        <property name="name" value="EMI Studios"/>
    </bean>

    <bean id="album" class="org.kodejava.example.spring.collection.Album">
        <property name="title" value="Please Please Me"/>
        <property name="year" value="1963"/>
        <property name="publisher">
            <map>
                <entry key="publisher" value-ref="publisher"/>
            </map>
        </property>
    </bean>

</beans>
```


The `<map>` element can have many `<entry>` elements. We can use the `key` attribute to use a string as its key. If you want the key to be a reference to other bean in the Spring context you can use the `key-ref` instead.

The `value-ref` is used to set the value to refer to another bean. If the value is a simple value such as string you can use the `value` attribute.

To run it create the following program:

```java
package org.kodejava.example.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMap {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"collection-map.xml"});

        Album album = (Album) context.getBean("album");
        System.out.println("Album = " + album);
    }
}
```

And here what you'll get on the console:

```text
Album = Album{title='Please Please Me', year=1963, songs=[], publisher={publisher=Publisher{name=EMI Studios}}, props={}}
```
