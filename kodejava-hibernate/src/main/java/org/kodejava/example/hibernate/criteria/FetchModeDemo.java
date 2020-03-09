package org.kodejava.example.hibernate.criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.kodejava.example.hibernate.model.Record;

import java.util.List;

public class FetchModeDemo {
    public static Session getSession() throws HibernateException {
        String cfg = "hibernate.cfg.xml";
        SessionFactory sessionFactory = new Configuration().configure(cfg)
            .buildSessionFactory();
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Session session = getSession()) {
            Criteria criteria = session.createCriteria(Record.class)
                .setFetchMode("artist", FetchMode.SELECT)
                .setFetchMode("label", FetchMode.SELECT)
                .add(Restrictions.eq("title", "Please Please Me"));

            List<Record> records = criteria.list();
            for (Record record : records) {
                System.out.println("Recording  = "
                    + record.getTitle());
                System.out.println("Artist     = "
                    + record.getArtist().getName());
            }
        }
    }
}
