package by.itacademy.dao;

import by.itacademy.connection.ConnectionPool;
import by.itacademy.model.Person;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

import static by.itacademy.connection.ConnectionPool.getConnection;

public class PersonDao {
    private static final Object LOCK = new Object();
    private static PersonDao INSTANCE = null;

    public static PersonDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonDao();
                }
            }
        }
        return INSTANCE;
    }

    public Long save(Person person) {
        Session currentSession = getConnection();
        currentSession.beginTransaction();
        Serializable id = currentSession.save(person);
        currentSession.getTransaction().commit();
        currentSession.close();
        return (Long) id;
    }

    public Person findById(Long id) {
        Session session = getConnection();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    public void delete(Person person) {
        Session session = getConnection();
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    public List<Person> findAll() {
        Session currentSession = getConnection();
        List<Person> personList = currentSession.createQuery("select c from Person c", Person.class).list();
        currentSession.close();
        return personList;
    }
}