# How do I create a Criteria object?

This example show you how to create an instance of Hibernate `Criteria` class. To create a `Criteria` we call the factory method of the `Session` object and pass the persistence class as parameter. To execute the `Criteria` query we simply call the `list()` method.

```java
package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.kodejava.example.hibernate.model.Track;

import java.util.List;

public class CreateCriteriaDemo {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Session session = getSession()) {
            // Create a new Criteria to query for a collection of Tracks.
            // To create an instance of Criteria we call a createCriteria()
            // factory method of the Session object.
            Criteria criteria = session.createCriteria(Track.class);

            // Call the list() method to retrieve a collections of Tracks
            // from the database.
            List<Track> tracks = criteria.list();

            for (Track t : tracks) {
                System.out.println("Title     = " + t.getTitle());
                System.out.println("Artist    = " + t.getArtist().getName());
                System.out.println("Genre     = " + t.getGenre().getName());
                System.out.println("Record    = " + t.getRecord().getTitle());
                System.out.println("Label     = " + t.getRecord().getLabel().getName());
                System.out.println("-----------------------------------");
            }
        }
    }
}
```

