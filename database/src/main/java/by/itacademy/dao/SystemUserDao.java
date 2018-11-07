package by.itacademy.dao;

import static by.itacademy.connection.ConnectionPool.getConnection;
import by.itacademy.model.SystemUser;
import org.hibernate.Session;

import java.io.Serializable;

public class SystemUserDao {
    private static final Object LOCK = new Object();
    private static SystemUserDao INSTANCE = null;

    public static SystemUserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new SystemUserDao();
                }
            }
        }
        return INSTANCE;
    }

    public Long save(SystemUser systemUser) {
        Session currentSession = getConnection();
        currentSession.beginTransaction();
        Serializable id = currentSession.save(systemUser);
        currentSession.getTransaction().commit();
        currentSession.close();
        return (Long) id;
    }

    public void delete(Long id) {
        Session session = getConnection();
        session.beginTransaction();
        SystemUser systemUser = new SystemUser();
        systemUser.setId(id);
        systemUser.setEmail("del");
        systemUser.setPasswordUser("del");
        session.delete(systemUser);
        session.getTransaction().commit();
        session.close();
    }

    public SystemUser findById(Long id) {
        Session session = getConnection();
        session.beginTransaction();
        SystemUser mySystemUser = session.get(SystemUser.class, id);
        session.close();
        return mySystemUser;
    }

}