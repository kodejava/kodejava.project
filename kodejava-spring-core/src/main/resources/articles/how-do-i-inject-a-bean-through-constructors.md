# How do I inject a bean through constructors?

The following example demonstrate how we can inject a bean through their constructors. We will create a couple interfaces and classes for this purpose. First we will create the `Singer` interface and the `Instrument` interface. The `Singer` interface define a single method call `sing()` that will enable the implementation to sing a song.

The second interface, `Instrument` also define a single method call `play()`. This method will allow the implementation to play some instrument. After defining our example interface we create an implementation for each of them. The class will be called the `AnySinger` and `Piano`.

Here are the code that we have to code so far:

```java
package org.kodejava.example.spring.singer;

public interface Singer {
    /**
     * Sing a song.
     */
    void sing();
}
```

```java
package org.kodejava.example.spring.singer;

public interface Instrument {
    /**
     * Play an instrument.
     */
    void play();
}
```

```java
package org.kodejava.example.spring.singer;

public class AnySinger implements Singer {
    private String song = "Nana nana nana";
    private Instrument instrument = null;

    public AnySinger() {
    }

    /**
     * A constructor to create singer to sing a specific song.
     *
     * @param song the song title to sing.
     */
    public AnySinger(String song) {
        this.song = song;
    }

    /**
     * A constructor to create singer to sing a song while playing
     * an instrument.
     *
     * @param song the song title to sing.
     * @param instrument the instrument to play.
     */
    public AnySinger(String song, Instrument instrument) {
        this.song = song;
        this.instrument = instrument;
    }

    @Override
    public void sing() {
        System.out.println("Singing " + song);
        if (instrument != null) {
            instrument.play();
        }
    }
}
```

```java
package org.kodejava.example.spring.singer;

public class Piano implements Instrument {

    @Override
    public void play() {
        System.out.println("Playing the Piano");
    }
}
```

We have created the classes that we need for our program to work. The next step is to create our spring configuration file. This will configure our bean in the spring container and wire all the dependency required by the bean.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="piano" class="org.kodejava.example.spring.singer.Piano"/>

    <bean id="singer" class="org.kodejava.example.spring.singer.AnySinger">
        <constructor-arg value="Dust in The Wind"/>
        <constructor-arg ref="piano"/>
    </bean>
    
</beans>
```

In the spring configuration we declare two beans. The first bean is the `piano` bean, which is a type of instrument. The main object of our example is the `singer` bean. To create the singer we use a constructor injector to inject some values or object reference for the bean to use.

In the `singer` bean we use the `&lt;constructor-arg/&gt;` element to inject dependency for the object. The `value` attribute can be use for passing a string or other primitive value. To pass an object reference we need to use the `ref` attribute.

Finally, we'll create a simple program to run our constructed spring application. The code will include the process of loading our spring container, obtaining the bean from the container. Let's see our singer in action.

```java
package org.kodejava.example.spring.singer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingerDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("singer.xml");

        Singer singer = (Singer) context.getBean("singer");
        singer.sing();
    }
}
```
