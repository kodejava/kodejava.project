# How do I create JPA EntityManagerFactory?

In this code snippet you will learn how to create JPA `EntityManagerFactory`. This factory enable you to create the `EntityManager` which will be used to execute the JPA command to manipulate the database tables.

To create the `EntityManagerFactory` you need to create to `persistence.xml` file first. The file is where you configure the JPA. This file must be placed inside the `META-INF` directory in your program working directory.

Here is an example of the `persistence.xml` file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0" xmlns="http://java.sun.com/xml/ns/persistence">

    <persistence-unit name="music" transaction-type="RESOURCE_LOCAL">
        <class>org.kodejava.example.jpa.entity.Artist</class>
        <class>org.kodejava.example.jpa.entity.Genre</class>
        <class>org.kodejava.example.jpa.entity.Label</class>
        <class>org.kodejava.example.jpa.entity.Record</class>
        <class>org.kodejava.example.jpa.entity.Review</class>
        <class>org.kodejava.example.jpa.entity.Reviewer</class>
        <class>org.kodejava.example.jpa.entity.Track</class>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/musicdb"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL55Dialect"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="create"/>
        </properties>
    </persistence-unit>

</persistence>
```

The persistence unit defined in the `persistence.xml` file contains a set of entities object. We also define some properties related to the database connections including the JDBC driver class, JDBC url, the username and password for opening the connection to database.

After defining the `persistence.xml` file we'll create a simple program to create the `EntityManagerFactory`. To create the factory we can use the `javax.persistence.Persistence` class `createEntityManagerFactory()` method and pass the persistence unit name as the parameter. In this example the persistence unit name is `music` as can be seen in the `persistence.xml` file.

After we have the factory object created we can then create an `EntityManager` by calling the `createEntityManager()` of the factory object. Let's see the code snippet below.

```java
package org.kodejava.example.jpa;

import org.kodejava.example.jpa.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryExample {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();

        // Do something with the entity manager.
        Artist artist = manager.find(Artist.class, 1L);
        System.out.println("Artist = " + artist);
    }
}
```

The `Artist` entity class definition.

```java
package org.kodejava.example.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "artists")
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 100, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
            Objects.equals(name, artist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Artist{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
```

Our project directory structure.

```
├── pom.xml
└── src
    └── main
        ├── java
        │   └── org
        │       └── kodejava
        │           └── example
        │               └── jpa
        │                   ├── EntityManagerFactoryExample.java
        │                   └── entity
        │                       ├── Artist.java
        │                       ├── Genre.java
        │                       ├── Label.java
        │                       ├── Record.java
        │                       ├── Review.java
        │                       ├── Reviewer.java
        │                       └── Track.java
        └── resources
            └── META-INF
                └── persistence.xml
```

**Maven Dependencies**

```xml
<dependencies>
    <!-- https://search.maven.org/remotecontent?filepath=javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2.jar -->
    <dependency>
        <groupId>javax.persistence</groupId>
        <artifactId>javax.persistence-api</artifactId>
        <version>2.2</version>
    </dependency>
    <!-- https://search.maven.org/remotecontent?filepath=org/hibernate/hibernate-core/5.4.1.Final/hibernate-core-5.4.1.Final.jar -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.4.1.Final</version>
    </dependency>
    <!-- https://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
```

[![Maven Central](https://img.shields.io/maven-central/v/javax.persistence/javax.persistence-api.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22javax.persistence%22%20AND%20a:%22javax.persistence-api%22)
[![Maven Central](https://img.shields.io/maven-central/v/org.hibernate/hibernate-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.hibernate%22%20AND%20a:%22hibernate-core%22)
[![Maven Central](https://img.shields.io/maven-central/v/mysql/mysql-connector-java.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22mysql%22%20AND%20a:%22mysql-connector-java%22)
