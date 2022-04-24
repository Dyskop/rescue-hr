package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.BaseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T extends BaseEntity> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}