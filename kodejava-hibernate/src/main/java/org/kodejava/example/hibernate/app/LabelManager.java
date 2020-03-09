package org.kodejava.example.hibernate.app;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kodejava.example.hibernate.model.Label;

import java.util.List;

public class LabelManager {
    public List<Label> getLabels() {
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // We read labels record from database using a simple Hibernate
        // query, the Hibernate Query Language (HQL).
        List<Label> labels = session.createQuery("from Label", Label.class)
            .list();
        session.getTransaction().commit();

        return labels;
    }

    public Label getLabel(Long id) {
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // We get back Label object from database by calling the Session
        // object get() method and passing the object type and the object
        // id to be read.
        Label label = session.get(Label.class, id);
        session.getTransaction().commit();

        return label;
    }

    public void saveLabel(Label label) {
        // To save an object we first get a session by calling
        // getCurrentSession() method from the SessionFactoryHelper
        // class. Next we create a new transaction, save the Label object
        // and commit it to database,
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(label);
        session.getTransaction().commit();
    }

    public void deleteLabel(Long id) {
        // Load the object to be deleted
        Label label = getLabel(id);

        // We get the current session and delete the Label object from
        // database.
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(label);
        session.getTransaction().commit();
    }

    public List<Label> getLabels(int pageNumber, int pageSize) {
        Session session =
            SessionFactoryHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Label> query = session.createQuery("from Label", Label.class);

        // Set the first record position and the max number of record to be
        // read. The setFirstResult() tell hibernate from which row the data
        // should be read. In the example if we have pages of 10 records,
        // passing the page number 2 will read 10 records from the 20th row
        // in the selected records.
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Label> labels = query.list();
        session.getTransaction().commit();
        return labels;
    }
}
