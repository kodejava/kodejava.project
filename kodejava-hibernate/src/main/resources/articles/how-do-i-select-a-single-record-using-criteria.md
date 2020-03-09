# How do I select a single record using Hibernate Criteria?

The `Criteria.uniqueResult()` method make it easier to query a single instance of a persistence object. When no persistence found this method will return a `null` value.

```java
package org.kodejava.example.hibernate.criteria;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.kodejava.example.hibernate.model.Genre;

public class UniqueResultExample {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        try (Session session = getSession()) {
            Criteria criteria = session.createCriteria(Genre.class)
                .add(Restrictions.eq("id", 1L));

            // Convenience method to return a single instance that matches
            // the query, or null if the query returns no results.
            Object result = criteria.uniqueResult();
            if (result != null) {
                Genre genre = (Genre) result;
                System.out.println("Genre = " + genre.getName());
            }
        }
    }
}
```
