# How do I inject collections using list element in Spring?

The following example show you how to use the `<list>` element to wire collections property. We can use it to wire property of either arrays or some implementation of `java.util.Collection` such as `java.util.ArrayList`.

For this example we will create a bean called `Album` that have a collection of `Song` beans in it. So here is our bean classes.

```java
package org.kodejava.example.spring.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Album {
    private String title;
    private int year;
    private List<Song> songs = new ArrayList<>();
    private Map<String, Publisher> publisher = new HashMap<>();
    private Properties props = new Properties();

    public Album() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setPublisher(Map<String, Publisher> publisher) {
        this.publisher = publisher;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Album{" +
            "title='" + title + '\'' +
            ", year=" + year +
            ", songs=" + songs +
            ", publisher=" + publisher +
            ", props=" + props +
            '}';
    }
}
```

```java
package org.kodejava.example.spring.collection;

public class Song {
    private String title;
    private String writer;

    public Song() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Song{" +
            "title='" + title + '\'' +
            ", writer='" + writer + '\'' +
            '}';
    }
}
```

```java
package org.kodejava.example.spring.collection;

public class Publisher {
    private String name;

    public Publisher() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name=" + name +
                '}';
    }
}
```

Here is the Spring configuration file, `CollectionList.xml`.


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


    <bean id="album" class="org.kodejava.example.spring.collection.Album">
        <property name="title" value="Please Please Me"/>
        <property name="year" value="1963"/>
        <property name="songs">
            <list>
                <ref bean="song1"/>
                <ref bean="song2"/>
                <ref bean="song3"/>
            </list>
        </property>
    </bean>

</beans>
```

The part of the configuration that wire the songs collection is inside the `album` bean. You can see that we have a property name `songs`. This property have a `<list>` element that contains a couple `<ref>` elements referring to some `Song` type beans.

Now let's run it with the following code:

```java
package org.kodejava.example.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoList {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"collection-list.xml"});

        Album album = (Album) context.getBean("album");
        System.out.println("Album = " + album);
    }
}
```

You'll see the following output when you run the program:

```text
Album = Album{title='Please Please Me', year=1963, songs=[Song{title='I Saw Her Standing There', writer='Beatles'}, Song{title='Misery', writer='Beatles'}, Song{title='Anna (Go to Him)', writer='Beatles'}], publisher={}, props={}}
```
