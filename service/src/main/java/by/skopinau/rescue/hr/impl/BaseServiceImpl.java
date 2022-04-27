package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.BaseDaoImpl;
import by.skopinau.rescue.hr.model.BaseEntity;
import by.skopinau.rescue.hr.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    private final BaseDaoImpl<T> baseDaoImpl;

    @Autowired
    public BaseServiceImpl(BaseDaoImpl<T> baseDaoImpl) {
        this.baseDaoImpl = baseDaoImpl;
    }

    @Override
    public void save(T entity) {
        baseDaoImpl.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDaoImpl.update(entity);
    }

    @Override
    public void delete(T entity) {
        baseDaoImpl.delete(entity);
    }

    @Override
    public T findById(int id) {
        return baseDaoImpl.findById(id);
    }

    @Override
    public List<T> findAll() {
        return baseDaoImpl.findAll();
    }
}