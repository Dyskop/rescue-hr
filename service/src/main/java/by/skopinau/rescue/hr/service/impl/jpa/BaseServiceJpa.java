package by.skopinau.rescue.hr.service.impl.jpa;

import by.skopinau.rescue.hr.service.BaseService;
import by.skopinau.rescue.hr.dao.BaseDao;
import by.skopinau.rescue.hr.dao.jpa.BaseDaoJpa;
import by.skopinau.rescue.hr.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class BaseServiceJpa<T extends BaseEntity> implements BaseService<T> {
    private final BaseDao<T> baseDao;

    @Autowired
    public BaseServiceJpa(BaseDaoJpa<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public T findById(int id) {
        return baseDao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }
}