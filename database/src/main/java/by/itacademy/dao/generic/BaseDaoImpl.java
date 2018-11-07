package by.itacademy.dao.generic;

import by.itacademy.connection.ConnectionPool;
import by.itacademy.dao.generic.BaseDao;
import by.itacademy.model.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> modelClass;

    public BaseDaoImpl(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public Long save(T entity) {
        Session session = ConnectionPool.getInstance().getConnection();
        session.beginTransaction();
        Serializable id = session.save(entity);
        session.getTransaction().commit();
        session.close();
        return (Long) id;
    }

    @Override
    public List<T> findAll() {
        Session session = ConnectionPool.getInstance().getConnection();
        return session.createQuery(
                "FROM " + modelClass.getSimpleName(), modelClass)
                .getResultList();
    }
}
