# How do I create a pagination using Criteria?

To create a pagination or limit the result set returned by the `Criteria` query we can use the `setFirstResult()` and `setMaxResults()` method. The `setFirstResult()` method defines the first row to start with and the `setMaxResults()` method defines the maximum number of records to read. Let's see the demo below.

```java
package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.kodejava.example.hibernate.model.Track;

import java.util.List;

public class CriteriaPagingDemo {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Session session = getSession()) {
            Criteria criteria = session.createCriteria(Track.class);

            // Set the first record index to read from the result set.
            criteria.setFirstResult(0);
            // Set the maximum number of records to read
            criteria.setMaxResults(2);

            List<Track> tracks = criteria.list();
            for (Track track : tracks) {
                System.out.println("Track = " + track.getTitle());
            }
        }
    }
}
```
