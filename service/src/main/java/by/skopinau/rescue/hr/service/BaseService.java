package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.model.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}