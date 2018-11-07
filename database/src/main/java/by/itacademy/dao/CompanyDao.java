package by.itacademy.dao;

import static by.itacademy.connection.ConnectionPool.getConnection;
import by.itacademy.model.Company;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class CompanyDao {
    private static final Object LOCK = new Object();
    private static CompanyDao INSTANCE = null;
    public static CompanyDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CompanyDao();
                }
            }
        }
        return INSTANCE;
    }

    public Company findById(Long id) {
        Session session = getConnection();
        session.beginTransaction();
        Company myCompany = session.get(Company.class, id);
        session.close();
        return myCompany;
    }

    public Long save(Company company) {
        Session currentSession = getConnection();
        currentSession.beginTransaction();
        Serializable id = currentSession.save(company);
        currentSession.getTransaction().commit();
        currentSession.close();
        return (Long) id;
    }

    public List<Company> findAll() {
        Session currentSession = getConnection();
        List<Company> companyList = currentSession.createQuery("select c from Company c", Company.class).list();
        currentSession.close();
        return companyList;
    }

    public void delete(Company company) {
        Session session = getConnection();
        session.beginTransaction();
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    }
}






