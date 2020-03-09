package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.kodejava.example.hibernate.model.Genre;

import java.util.List;

public class RestrictionInDemo {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Session session = getSession()) {
            // Create a Criteria an add an in constraint for the property
            // id. This in restrictions will return genre with id 1, 2, 3
            // and 4.
            Criteria criteria = session.createCriteria(Genre.class)
                .add(Restrictions.in("id", 1L, 2L, 3L, 4L));

            List<Genre> result = criteria.list();
            for (Genre genre : result) {
                System.out.println(genre);
            }
        }
    }
}
