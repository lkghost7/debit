package by.itacademy.dao;

import by.itacademy.dao.generic.BaseDao;
import by.itacademy.dao.generic.BaseDaoTest;
import by.itacademy.dao.generic.CompanDaoImpl;
import by.itacademy.model.Company;
import org.junit.Test;

public class CompanDaoImplTest extends BaseDaoTest<Company> {

    private BaseDao<Company> dao = new CompanDaoImpl(Company.class);

    @Test
    public void save() {
        CompanDaoImpl dao = new CompanDaoImpl(Company.class);
        Company company = new Company();
        company.setName("Vinty-Company");
       dao.save(company);
    }

    @Override
    protected BaseDao<Company> getDao() {
        return dao;
    }

    @Override
    protected Company getModel() {
        return new Company("Vintokril");
    }
}
