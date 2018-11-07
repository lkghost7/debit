package by.itacademy.dao.generic;

import by.itacademy.model.BaseEntity;

import java.util.List;

public interface BaseDao <T extends BaseEntity> {

    Long save(T entity);

    List<T> findAll();

}