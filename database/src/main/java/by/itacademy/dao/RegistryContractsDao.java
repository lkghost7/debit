package by.itacademy.dao;

import static by.itacademy.connection.ConnectionPool.getConnection;
import by.itacademy.model.RegistryOfContract;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class RegistryContractsDao {
    private static final Object LOCK = new Object();
    private static RegistryContractsDao INSTANCE = null;

    public static RegistryContractsDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RegistryContractsDao();
                }
            }
        }
        return INSTANCE;
    }

    public Long save(RegistryOfContract registry) {
        Session currentSession = getConnection();
        currentSession.beginTransaction();
        Serializable id = currentSession.save(registry);
        currentSession.getTransaction().commit();
        currentSession.close();
        return (Long) id;
    }

    public List<RegistryOfContract> findAll() {
        Session currentSession = getConnection();
        List<RegistryOfContract> registry = currentSession.createQuery("select r from RegistryOfContract r",
                RegistryOfContract.class).list();
        currentSession.close();
        return registry;
    }

    public void delete(RegistryOfContract registry) {
        Session session = getConnection();
        session.beginTransaction();
        session.delete(registry);
        session.getTransaction().commit();
        session.close();
    }
}