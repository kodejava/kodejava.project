# How do I add Restrictions to the Criteria object?

In this example you'll learn how to add restrictions to the `Criteria` object. Using restriction we can narrow the result of our query. In the code below we add some restrictions such as `Restrictions.eq()`, `Restrictions.like()` and `Restrictions.isNotNull()`.

In the Hibernate framework you'll find a lot of class the use a method chaining. As in the example below you can see that we actually can add an endless restrictions by calling the `add()` method.

```java
package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;
import org.kodejava.example.hibernate.model.Track;

import java.util.List;

public class RestrictionsDemo {
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
                .createAlias("artist", "artist")
                .createAlias("genre", "genre")
                .add(Restrictions.eq("title", "Ob-La-Di, Ob-La-Da"))
                .add(Restrictions.like("artist.name", "%beatles%"))
                .add(Restrictions.isNotNull("genre.name"));

            List<Track> tracks = criteria.list();
            for (Track track : tracks) {
                System.out.println("Track = " + track.getTitle() +
                    "; Artist = " + track.getArtist().getName() +
                    "; Genre = " + track.getGenre().getName());
            }
        }
    }
}
```

Here are some other restrictions that can also be use to narrow our `Criteria` query result, for a complete restrictions you can see the [Restrictions](https://docs.jboss.org/hibernate/orm/5.4/javadocs/org/hibernate/criterion/Restrictions.html) class documentation.

* `Restrictions.ne("title", "Twist and Shout")` - Apply a "not equal" constraint to the named property.
* `Restrictions.ilike("title", "Twist%")` - A case-insensitive "like".
* `Restrictions.isNull("title")` - Apply an "is null" constraint to the named property.
* `Restrictions.gt("duration", new Integer(200))` - Apply a "greater than" constraint to the named property.
* `Restrictions.between("duration", new Integer(100), new Integer(200))` - Apply a "between" constraint to the named property
* `Restrictions.or(criterionA, criterionB)` - Return the disjunction of two expressions.
* `Restrictions.disjuction()` - Group expressions together in a single disjunction.
