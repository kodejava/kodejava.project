# How do I order the Criteria query resultset?

In this demo you'll see how to order the resultset of out `Criteria` query. It can be done by adding the `org.hibernate.criterion.Order` into the `Criteria` object and we can either order the result in ascending or descending order.

```java
package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.kodejava.example.hibernate.model.Track;

import java.util.List;

public class CriteriaOrderDemo {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Session session = getSession()) {
            Criteria criteria = session.createCriteria(Track.class)
                .addOrder(Order.asc("title"))
                .setFirstResult(0)
                .setMaxResults(10);

            List<Track> tracks = criteria.list();
            for (Track track : tracks) {
                System.out.println("Track = " + track.getTitle());
            }
        }
    }
}
```
