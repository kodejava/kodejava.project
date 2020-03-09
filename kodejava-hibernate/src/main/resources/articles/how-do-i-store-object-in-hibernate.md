# How do I store object in Hibernate?

This example shows you how to store or save Hibernate object to database. The basic steps in creating application in Hibernate will be:

* Creates the POJO
* Create the Hibernate mapping file
* Register the mapping file in the Hibernate configuration
* Create a simple manager class to store the object

In this example we'll create a class called `Label`, this class is about a _record label company_. This class has the `id`, `name`, `created` and `modified` attributes. Their types in order are `Integer`, `String`, `java.util.Date` and `java.util.Date`.

Hibernate is an Object Relation Mapping technology which basically means how an object is mapped to a relational database model. Because of this it needs a mapping file to map the object properties to table columns. The mapping file usually named in the format of `Label.hbm.xml`, the class name with `hbm.xml` suffix. And for Hibernate application recognize the object, the mapping file should be registered in the Hibernate configuration `hibernate.cfg.xml` file.

We have a brief introduction about the Hibernate class and configuration structure. Let's jump the the working example. First we creates the mapping file and then we create the classes.

```xml
<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <class name="org.kodejava.example.hibernate.model.Label" table="labels">
        <id name="id" column="id">
            <generator class="native"/>
        </id>
        <property name="name" not-null="true"/>
        <property name="created" column="created" type="timestamp"/>
        <property name="modified" column="modified" type="timestamp"/>
    </class>
</hibernate-mapping>
```

```java
package org.kodejava.example.hibernate.model;

import java.util.Date;

public class Label {
    private Long id;
    private String name;
    private Date created;
    private Date modified;

    // Getters & Setters 
    
    @Override
    public String toString() {
        return "Label{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", created=" + created +
            ", modified=" + modified +
            '}';
    }
}
```

```java
package org.kodejava.example.hibernate.app;

import org.hibernate.Session;
import org.kodejava.example.hibernate.model.Label;

public class LabelManager {
    public void saveLabel(Label label) {
        // To save an object we first get a session by calling 
        // getCurrentSession() method from the SessionFactoryHelper class. 
        // Next we create a new transaction, save the Label object and 
        // commit it to database,
        Session session = SessionFactoryHelper.getSessionFactory()
            .getCurrentSession();

        session.beginTransaction();
        session.save(label);
        session.getTransaction().commit();
    }
}
```

```java
package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

import java.util.Date;

public class InsertDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        // Creates a Label object we are going to stored in the database.
        // We set the name, modified by and modified date information.
        Label label = new Label();
        label.setName("Sony Music");
        label.setCreated(new Date());

        // Call the LabelManager saveLabel method.
        manager.saveLabel(label);
    }
}
```

We have the code and the mapping file done. To register the mapping file in the Hibernate configuration file you can see the [How do I create Hibernate's SessionFactory?](//kodejava.org/how-do-i-create-hibernates-sessionfactory/) example. The example also tells you how to create the `SessionFactoryHelper` class to obtain the Hibernate's `SessionFactory`.

**Maven Dependencies**

```xml
<dependencies>
    <!--https://search.maven.org/remotecontent?filepath=org/hibernate/hibernate-core/5.4.1.Final/hibernate-core-5.4.1.Final.jar-->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.4.1.Final</version>
    </dependency>
    <!--https://search.maven.org/remotecontent?filepath=org/hibernate/hibernate-ehcache/5.4.1.Final/hibernate-ehcache-5.4.1.Final.jar-->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-ehcache</artifactId>
        <version>5.4.1.Final</version>
    </dependency>
    <!--https://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
```

[![Maven Central](https://img.shields.io/maven-central/v/org.hibernate/hibernate-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.hibernate%22%20AND%20a:%22hibernate-core%22)
[![Maven Central](https://img.shields.io/maven-central/v/org.hibernate/hibernate-ehcache.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.hibernate%22%20AND%20a:%22hibernate-ehcache%22)
