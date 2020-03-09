package org.kodejava.example.hibernate.app;

import org.hibernate.Session;

public class SessionFactoryDemo {
    public static void main(String[] args) {
        Session session = SessionFactoryHelper.getSessionFactory()
            .getCurrentSession();

        System.out.println("session = " + session);
    }
}
