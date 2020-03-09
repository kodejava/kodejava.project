# How do I compare values in Spring EL?

In Spring EL you can compare two values to know if they are equals, is greater or smaller than the other value.  For these kind of comparison below are the list of operators supported by Spring EL, as expected it supports the same operators as in the Java programming language.

The Spring Expression Language comparison operators includes:

| Symbol | Textual | Description |
|:---:|:---:|:---|
| `==` | `eq` | Double-equal operator to compare two values for equality. |
| `<` | `lt` | Less-than operator to compare if a value is smaller than the other value. |
| `>` | `gt` | Greater-than operator to compare if a value is greater than the other value. |
| `<=` | `le` | Less-than-or-equal operator to compare if a value is smaller or equals to another value. |
| `>=` | `ge` | Greater-than-or-equal operator to compare if a value is greater or equals to another value. |

For example you can use the double-equal operator like the following XML configuration:

```xml
<property name="empty" value="#{myGlass.volume == 0}"/>
```

It means that we are going to set the `empty` property to be either a boolean `true` or `false` if the value of `myGlass.volume` is equal to `0` or not. The double-equal symbol is not a problem when use in the XML document. But you will understand right away that you can't use the less-than (<) or greater-than (>) symbol in XML, because the characters is used to define the XML document it self.

To make it work we must use the textual version of these operators. For example you will use the `lt` instead of `<` symbol or `gt` instead of the `>` symbol as can be see in the table above. Now let's see an example in the spring configuration file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myGlass" class="org.kodejava.example.spring.el.MyGlass">
        <constructor-arg name="volume" value="5"/>
        <constructor-arg name="maxVolume" value="10"/>
        <property name="empty" value="#{myGlass.volume == 0}"/>
        <property name="halfEmpty" value="#{(myGlass.maxVolume / 2) le myGlass.volume}"/>
    </bean>

</beans>
```

In the above configuration we have a bean called `myGlass`. We instantiate it with two constructor values, the `volume` was set to `5` and the `maxVolume` was set to `10`. To set the value of the `empty` and `halfEmpty` property we use the double-equal and less-than-equal operator to check the value of the `volume` and `maxVolume` properties.

After you have the spring configuration, let's create the `MyGlass` bean and an application to run the configuration file. The bean is just a simple class with some properties and a collections of getters and setters.

```java
package org.kodejava.example.spring.el;

public class MyGlass {
    private boolean empty;
    private boolean halfEmpty;
    private int volume;
    private int maxVolume;

    public MyGlass() {
    }

    public MyGlass(int volume, int maxVolume) {
        this.volume = volume;
        this.maxVolume = maxVolume;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isHalfEmpty() {
        return halfEmpty;
    }

    public void setHalfEmpty(boolean halfEmpty) {
        this.halfEmpty = halfEmpty;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }
}
```

To run the spring configuration above you can create the `SpELCompareValue` class below.

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELCompareValue {
    public static void main(String[] args) {
        ApplicationContext context = new
            ClassPathXmlApplicationContext("spel-compare-value.xml");

        MyGlass glass = (MyGlass) context.getBean("myGlass");
        System.out.println("glass.getVolume()   = " + glass.getVolume());
        System.out.println("glass.isEmpty()     = " + glass.isEmpty());
        System.out.println("glass.isHalfEmpty() = " + glass.isHalfEmpty());
    }
}
```

And when you executed the code above you will get the following output:

```text
glass.getVolume()   = 5
glass.isEmpty()     = false
glass.isHalfEmpty() = true
```
