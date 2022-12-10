package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {
    Optional<T> save(T entity);

    List<T> findAll();

    Optional<T> findById(int id);

    Optional<T> update(int id, T entity);

    boolean delete(int id);
}