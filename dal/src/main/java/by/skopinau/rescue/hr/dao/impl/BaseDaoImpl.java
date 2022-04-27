package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.dao.BaseDao;
import by.skopinau.rescue.hr.model.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> tClass;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public BaseDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().remove(entity);
    }

    @Override
    public T findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        T t = session.find(tClass, id);
        if (t == null) {
            throw new NullPointerException("Некорректный параметр поиска");
        } else return t;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(tClass);
        criteria.select(criteria.from(tClass));
        if (session.createQuery(criteria).getResultList().isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return session.createQuery(criteria).getResultList();
    }
}