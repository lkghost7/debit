package by.itacademy.dao.generic;

import by.itacademy.connection.ConnectionPool;
import by.itacademy.dao.generic.BaseDao;
import by.itacademy.model.BaseEntity;
import org.hibernate.Session;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> modelCalss;

    public BaseDaoImpl(Class<T> modelClass) {
        this.modelCalss = modelClass;
    }

    @Override
    public void save(T entity) {
        Session session = ConnectionPool.getInstance().getConnection();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }
    
    
}
