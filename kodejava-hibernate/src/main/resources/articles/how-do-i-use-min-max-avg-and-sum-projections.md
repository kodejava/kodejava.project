# How do I use min, max, avg and sum Projections?

The code below demonstration the use of `Projections.min()`, `Projections.max()`, `Projections.avg()` and `Projections.sum()`.

```java
package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.kodejava.example.hibernate.model.Track;

public class MinMaxAvgSumProjectionsDemo {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        try (Session session = getSession()) {
            Criteria criteria = session.createCriteria(Track.class)
                .setProjection(Projections.max("duration"));
            Integer maxDuration = (Integer) criteria.uniqueResult();
            System.out.println("Max Track Duration = " + maxDuration);

            criteria.setProjection(Projections.min("duration"));
            Integer minDuration = (Integer) criteria.uniqueResult();
            System.out.println("Min Track Duration = " + minDuration);

            criteria.setProjection(Projections.avg("duration"));
            Double avgDuration = (Double) criteria.uniqueResult();
            System.out.println("Avg Track Duration = " + avgDuration);

            criteria.setProjection(Projections.sum("duration"));
            Long totalDuration = (Long) criteria.uniqueResult();
            System.out.println("Total Track Duration = " + totalDuration);
        }
    }
}
```
