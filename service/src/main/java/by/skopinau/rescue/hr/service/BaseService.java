package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    void save(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}