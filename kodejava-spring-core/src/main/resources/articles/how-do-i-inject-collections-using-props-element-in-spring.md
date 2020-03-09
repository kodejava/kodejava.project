# How do I inject collections using props element in Spring?

This time we will demonstrate how to inject a `java.util.Properties`. This class store a key-value pairs of data where the key and the values are both in string. You can use the `<props>` element to wire a property collections.

The bean we use in this example is taken from the previous example [How do I inject collections using list element in Spring?](//kodejava.org/how-do-i-inject-collections-using-list-element-in-spring/).

Let's create the configuration file and call it `CollectionProps.xml`.

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
        <property name="props">
            <props>
                <prop key="color">Black</prop>
                <prop key="type">CD</prop>
                <prop key="duration">1 Hour</prop>
            </props>
        </property>
    </bean>

</beans>
```

To wire property collections we use the `<props>` element. This element can have many `<prop>` in it. The key of the property defined by the `key` attribute of this element. The value of the property is set in the body of this element.

As usual let's create a simple program to run it:

```java
package org.kodejava.example.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoProps {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"collection-props.xml"});

        Album album = (Album) context.getBean("album");
        System.out.println("Album = " + album);
    }
}
```

When you run it, it will produce the following output:

```text
Album = Album{title='Please Please Me', year=1963, songs=[], publisher={}, props={color=Black, type=CD, duration=1 Hour}}
```
