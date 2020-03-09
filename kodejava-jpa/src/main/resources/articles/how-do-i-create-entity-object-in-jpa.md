# How do I create entity object in JPA?

This example show you a simple example of an entity object used for mapping database table into java object. The entity is a Plain Old Java Object (POJO). The JPA specification doesn't mandate the class to extends or implements other class or interfaces.

A class which going to be persisted in a database must be annotated with the `javax.persistence.Entity` annotation (`@Entity`). As you can see in the `Record` class below.

By default the mapped table name equals to the class name. But if your table name is different to your class name you can use the `@Table` annotation. Set the table name using the `name` attribute of this annotation. This annotation is also located in the `javax.persistence` package.

```java
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "records")
public class Record implements Serializable {
}
```

In JPA metadata can be added either in the class fields or using using the getters or setters methods. Choose one option because you cannot mix both of them in the same entity object. Here we will annotate the getters of the class.

To define the primary key of the entity we use the `@Id` annotation. The `@GeneratedValue` annotation is used to define how the primary key of the entity should be generated. For example in this example the strategy is defined as `GenerationType.AUTO`. In MySQL database this is implemented as an `auto-increment` column.

```
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getId() {
    return id;
}
```

The fields of the entity by default will be persisted into corresponding fields in the database table. If you don't want the entity fields to be persisted you must add the `@Transient` annotation to it. If your entity field name is different with table field you can use the `@Column` annotation to define the column name and other attributes of the column such as the length, the uniqueness of the field and the not-null attribute.

To define relationship between entity object you can use annotation such as `@OneToOne`, `@OneToMany`, `@ManyToOne` and `@ManyToMany`. This annotation represent the relationship between database tables in the Java objects.

```
@Column(nullable = false, length = 50)
public String getTitle() {
    return title;
}

@Column(name = "release_date")
public Date getReleaseDate() {
    return releaseDate;
}

@ManyToOne
@JoinColumn(nullable = false)
public Artist getArtist() {
    return artist;
}
```

This is the complete class for the `Record` entity. This will hold information about music record. This entity have relationship with other entity such the `Artist` and `Label` entity.

```java
package org.kodejava.example.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "records")
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Date releaseDate;
    private Artist artist;
    private Label label;

    private List<Track> trackList = new ArrayList<>();

    public Record() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Artist getArtist() {
        return artist;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Label getLabel() {
        return label;
    }

    @OneToMany(mappedBy = "record")
    public List<Track> getTrackList() {
        return trackList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
            Objects.equals(title, record.title) &&
            Objects.equals(releaseDate, record.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate);
    }

    @Override
    public String toString() {
        return "Record{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            '}';
    }
}
```

**Maven Dependencies**

```xml
<!-- https://search.maven.org/remotecontent?filepath=javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2.jar -->
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>
```

[![Maven Central](https://img.shields.io/maven-central/v/javax.persistence/javax.persistence-api.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22javax.persistence%22%20AND%20a:%22javax.persistence-api%22)
