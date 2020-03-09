# How do I wire properties with Spring's p namespace?

Beside using the `<property>` element, Spring framework also provide us another way to wiring value or reference into the bean. We can use the Spring's `p` namespaces. The `p` namespace has a schema URI of `http://www.springframework.org/schema/p`.

With this namespace declared in the Spring configuration file you can use the `p:` prefixed attribute of the `<bean>` element to wire bean's property.

We update the configuration used in the previous example [How do I inject into bean properties?](//kodejava.org/how-do-i-inject-into-bean-properties/) to use the `p` namespace. Here is the new Spring's configuration file.


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="rectangle" class="org.kodejava.example.spring.inject.Rectangle"/>

    <bean id="drawingBean"
          class="org.kodejava.example.spring.inject.DrawingBean"
          p:colour="Red" p:shape-ref="rectangle"/>

</beans>
```

The `p:color` attribute set the color property to Red, this is a simple value. To set the shape property we use the `p:shape-ref` attribute. The `-ref` suffix tell Spring that we are injecting a reference.

You can use the `<property>` element or using the `p` namespace to inject bean's property. Both of them have the same functionality.
