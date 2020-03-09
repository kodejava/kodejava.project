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
