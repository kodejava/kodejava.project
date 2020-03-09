# How do I inject collections using set element in Spring?

In this example you will see how to use the `<set>` element to wire a collection property of a bean. We will reuse the bean that we use in the previous example [How do I inject collections using list element in Spring?](//kodejava.org/how-do-i-inject-collections-using-list-element-in-spring/).

The `Album` bean have a `songs` property that have a type of `java.util.List`. The `<set>` element does not have to be used with `java.util.Set`. It can be used to wire a `java.util.List` collection. It just mean the it cannot contains duplicate values in it, so the collection will only contains a unique values.

Here how we configure our Spring context:

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
            <set>
                <ref bean="song1"/>
                <ref bean="song1"/>
                <ref bean="song1"/>
            </set>
        </property>
    </bean>

</beans>
```

The `<set>` configuration can bee seen in the `album` bean configuration. We set the `songs` property. Within this property element we use the `<set>` element. And then using the `<ref>` element we add some bean into the collection.

Create the following code to run it:

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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoSet {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"collection-set.xml"});

        Album album = (Album) context.getBean("album");
        System.out.println("Album = " + album);
    }
}
```

You'll see the following output in the screen. As you can see, although we set three beans into the `songs` property, the `Album` bean only contain a single song. This is because we use the `<set>` element to wire the collection. It does not allow duplicate values.

```text
Album = Album{title='Please Please Me', year=1963, songs=[Song{title='I Saw Her Standing There', writer='Beatles'}], publisher={}, props={}}
```
