package by.itacademy.dao;

import by.itacademy.dao.generic.BaseDao;
import by.itacademy.dao.generic.BaseDaoTest;
import by.itacademy.dao.generic.CompanDaoImpl;
import by.itacademy.model.Company;
import org.junit.Test;

import java.util.List;

public class CompanDaoImplTest extends BaseDaoTest<Company> {

    private static final BaseDao<Company> DAO = new CompanDaoImpl();

    @Override
    protected BaseDao<Company> getDao() {
        return DAO;
    }

    @Test
    public void save() {
        Company company = new Company();
        company.setName("Vinty-Company");
       DAO.save(company);
    }

    @Test
    public void findAll() {
        List<Company> all = DAO.findAll();
        System.out.println(all);
    }

    @Override
    protected Company getModel() {
        return new Company("Vintokril");
    }
}
