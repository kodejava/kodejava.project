# How do I wire / inject a null value in Spring?

To wire or inject a `null` value into a bean we can use the `<null>` element. The configuration below show you how to do it in the Spring configuration file. You might need to wire a `null` value for instance when you want to override a value that was autowired into a bean.

As you can see on the configuration below we set the value of property writer in the bean `song` to a `null` And we also set a couple `null` values into the `songs` property in the `album` bean.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="song" class="org.kodejava.example.spring.collection.Song">
        <property name="title" value="I Saw Her Standing There"/>
        <property name="writer">
            <null/>
        </property>
    </bean>

    <bean id="album" class="org.kodejava.example.spring.collection.Album">
        <property name="title" value="Please Please Me"/>
        <property name="year" value="1963"/>
        <property name="songs">
            <list>
                <ref bean="song"/>
                <null/>
                <null/>
            </list>
        </property>
    </bean>

</beans>
```

