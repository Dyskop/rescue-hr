package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}