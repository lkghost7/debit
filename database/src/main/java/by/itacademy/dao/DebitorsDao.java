package by.itacademy.dao;

import by.itacademy.connection.ConnectionPool;
import by.itacademy.model.Debitor;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class DebitorsDao {
    private static final Object LOCK = new Object();
    private static DebitorsDao INSTANCE = null;

    public static DebitorsDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new DebitorsDao();
                }
            }
        }
        return INSTANCE;
    }

    public Long save(Debitor debitor) {
        Session currentSession = ConnectionPool.getConnection();
        currentSession.beginTransaction();
        Serializable id = currentSession.save(debitor);
        currentSession.getTransaction().commit();
        currentSession.close();
        return (Long) id;
    }

    public List<Debitor> findAll() {
        Session currentSession = ConnectionPool.getConnection();
        List<Debitor> debitorList = currentSession.createQuery("select d from Debitor d", Debitor.class).list();
        currentSession.close();
        return debitorList;
    }

    public void delete(Debitor debitor) {
        Session session = ConnectionPool.getConnection();
        session.beginTransaction();
        session.delete(debitor);
        session.getTransaction().commit();
        session.close();
    }
}