# How do I use logical expression in Spring EL?

In the previous example you have learnt [How do I compare values in Spring EL?](//kodejava.org/how-do-i-compare-values-in-spring-el/). Where you saw how to compare two simple values for equality, less-than or greater-than, etc. In practice you might need to combine one or more of this comparison into a more complex logical expressions.

Spring EL also provides several operators that can be used to do this kind of logical operations. These operators are shown in the following table.

| Operator | Description |
|:---|:---|
| `and` | A logical AND operation; the result will be true of both sides are true. |
| `or` | A logical OR operation; the result will be true if at least on side is true. |
| `not` or `!` | A logical NOT operation; it will negates the expression value. |

Here is a example using the logical `and` operator in the spring configuration file:

```xml
<property name="largeGlass" value="#{smallGlass.maxVolume ge 20 and smallGlass.maxVolume le 30}"/>
```
          
The configuration above will set the `largeGlass` property above to `true` if the glass `maxVolume` is greater-that-or-equal to `20` and less-than-or-equal to `30`. It will only be considered as a large glass if the volume is between `20` and `30`. So we use the logical and operator in that expression to evaluate the value for the largeGlass property. Now let's see the complete example.

First let's define the `MyOtherGlass` pojo.

```
package org.kodejava.example.spring.el;

public class MyOtherGlass {
    private boolean empty;
    private boolean halfEmpty;
    private int volume;
    private int maxVolume;
    private boolean largeGlass;

    public MyOtherGlass() {
    }

    public MyOtherGlass(int volume, int maxVolume) {
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

    public boolean isLargeGlass() {
        return largeGlass;
    }

    public void setLargeGlass(boolean largeGlass) {
        this.largeGlass = largeGlass;
    }
}
```

After creating the pojo, let's now create our spring configuration file where we define the `smallGlass` bean and the `largeGlass` bean.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="smallGlass" class="org.kodejava.example.spring.el.MyOtherGlass">
        <constructor-arg name="volume" value="5"/>
        <constructor-arg name="maxVolume" value="10"/>
        <property name="largeGlass"
                  value="#{smallGlass.maxVolume ge 20 and smallGlass.maxVolume le 30}"/>
    </bean>
    <bean id="largeGlass" class="org.kodejava.example.spring.el.MyOtherGlass">
        <constructor-arg name="volume" value="5"/>
        <constructor-arg name="maxVolume" value="30"/>
        <property name="largeGlass"
                  value="#{largeGlass.maxVolume ge 20 and largeGlass.maxVolume le 30}"/>
    </bean>

</beans>
```

And finally let's create a class to run this configuration file in the console:

```java
package org.kodejava.example.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELLogicalExpression {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spel-logical-expression.xml");

        MyOtherGlass smallGlass =
            (MyOtherGlass) context.getBean("smallGlass");
        MyOtherGlass largeGlass =
            (MyOtherGlass) context.getBean("largeGlass");

        System.out.println("smallGlass.isLargeGlass() = " + smallGlass.isLargeGlass());
        System.out.println("largeGlass.isLargeGlass() = " + largeGlass.isLargeGlass());
    }
}
```

This code will give you the following output when executed:

```text
smallGlass.isLargeGlass() = false
largeGlass.isLargeGlass() = true
```
