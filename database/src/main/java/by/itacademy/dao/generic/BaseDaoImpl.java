package by.itacademy.dao.generic;


import by.itacademy.connection.ConnectionPool;
import by.itacademy.model.BaseEntity;
import lombok.Cleanup;
import org.hibernate.Session;

<<<<<<< .merge_file_a05788
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
=======
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;



public abstract class BaseDaoImpl<P extends Serializable, E extends BaseEntity<P>> implements BaseDao<P, E> {

    private Class<E> clazz;

//    public BaseDaoImpl(Class<E> clazz) {
//        this.clazz = clazz;
//    }

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<E>) type.getActualTypeArguments()[1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public P save(E entity) {
        @Cleanup Session session = ConnectionPool.getConnection();
        return (P) session.save(entity);
    }

    @Override
    public void update(E entity) {
        @Cleanup Session session = ConnectionPool.getConnection();
        session.update(entity);
    }

    @Override
    public void delete(E entity) {
        @Cleanup Session session = ConnectionPool.getConnection();
        session.delete(entity);
>>>>>>> .merge_file_a05680
    }

    @Override
    public E find(P id) {
        @Cleanup Session session = ConnectionPool.getConnection();
        return session.find(clazz, id);
    }

    @Override
    public List<E> findAll() {
        @Cleanup Session session = ConnectionPool.getConnection();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> criteria = cb.createQuery(clazz);

        criteria.select(criteria.from(clazz));

        return session.createQuery(criteria).list();

//        return session.createQuery(format("select e from %s e", clazz.getSimpleName()), clazz).list();
    }

//    public abstract Class<E> getEntityClass();
}
