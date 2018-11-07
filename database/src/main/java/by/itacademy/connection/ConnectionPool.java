package by.itacademy.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionPool {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public static Session getConnection() {
        return FACTORY.openSession();
    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }
}