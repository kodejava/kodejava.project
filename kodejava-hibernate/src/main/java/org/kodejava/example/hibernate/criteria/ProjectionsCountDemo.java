package org.kodejava.example.hibernate.criteria;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.kodejava.example.hibernate.model.Track;

import java.util.List;

public class ProjectionsCountDemo {
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
                .setProjection(Projections.rowCount());

            List result = criteria.list();
            if (!result.isEmpty()) {
                Long rowCount = (Long) result.get(0);
                System.out.println("Total records: " + rowCount);
            }
        }
    }
}
