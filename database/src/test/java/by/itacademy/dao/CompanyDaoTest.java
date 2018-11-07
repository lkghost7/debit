package by.itacademy.dao;

import by.itacademy.model.Company;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompanyDaoTest {

    @Test
    public void save() {
        Company company = new Company();
        company.setName("Новичёк2");
        CompanyDao.getInstance().save(company);
        CompanyDao.getInstance().delete(company);
    }
    @Test
    public void findAll () {
        List<Company> list = CompanyDao.getInstance().findAll();
        list.forEach(System.out::println);
    }
}
