package by.itacademy.dao;

import by.itacademy.model.Debitor;
import by.itacademy.model.EmailDetail;
import org.junit.Test;

import javax.validation.constraints.Email;

import java.util.List;

import static org.junit.Assert.*;

public class EmailDetailDaoTest {

    @Test
    public void findById() {
    }

    @Test
    public void save() {
        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setEmail("lk1@tut.by");
        EmailDetailDao.getInstance().save(emailDetail);
        EmailDetailDao.getInstance().delete(emailDetail);
    }

    @Test
    public void findAll() {
        List<EmailDetail> emailDetailList = EmailDetailDao.getInstance().findAll();
        emailDetailList.forEach(System.out::println);
    }

    @Test
    public void delete() {
    }
}