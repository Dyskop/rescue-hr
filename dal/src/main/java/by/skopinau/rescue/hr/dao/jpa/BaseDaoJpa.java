package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.BaseDao;
import by.skopinau.rescue.hr.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Transactional
@Repository
public abstract class BaseDaoJpa<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> tClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public BaseDaoJpa(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findById(int id) {
        T t = entityManager.find(tClass, id);
        if (t == null) {
            throw new NullPointerException("Некорректный параметр поиска");
        } else return t;
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(tClass);
        criteria.select(criteria.from(tClass));
        List<T> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }
}