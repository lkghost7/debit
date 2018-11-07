package by.itacademy.dao;

import static by.itacademy.connection.ConnectionPool.getConnection;
import by.itacademy.model.EmailDetail;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class EmailDetailDao {
    private static final Object LOCK = new Object();
    private static EmailDetailDao INSTANCE = null;
    public static EmailDetailDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new EmailDetailDao();
                }
            }
        }
        return INSTANCE;
    }
    public EmailDetail findById(Long id) {
        Session session = getConnection();
        session.beginTransaction();
        EmailDetail emailDetail = session.get(EmailDetail.class, id);
        session.close();
        return emailDetail;
    }

    public Long save(EmailDetail emailDetail) {
        Session currentSession = getConnection();
        currentSession.beginTransaction();
        Serializable id = currentSession.save(emailDetail);
        currentSession.getTransaction().commit();
        currentSession.close();
        return (Long) id;
    }

    public List<EmailDetail> findAll() {
        Session currentSession = getConnection();
        List<EmailDetail> emailDetails = currentSession.createQuery("select e from EmailDetail e", EmailDetail.class).list();
        currentSession.close();
        return emailDetails;
    }

    public void delete(EmailDetail emailDetail) {
        Session session = getConnection();
        session.beginTransaction();
        session.delete(emailDetail);
        session.getTransaction().commit();
        session.close();
    }
}
