package by.itacademy.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionPool {
        private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        public static Session getConnection() {
            return sessionFactory.openSession();
        }
}
