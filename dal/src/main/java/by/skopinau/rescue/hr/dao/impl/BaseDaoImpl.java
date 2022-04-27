package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.dao.BaseDao;
import by.skopinau.rescue.hr.model.BaseEntity;
import by.skopinau.rescue.hr.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> tClass;

    @Autowired
    public BaseDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public void save(T entity) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(T entity) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T entity) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T findById(int id) {
        try(Session session = SessionUtil.openSession()) {
            T t = session.find(tClass, id);
            if (t == null) {
                throw new NullPointerException("Некорректный параметр поиска");
            } else return t;
        }
    }

    @Override
    public List<T> findAll() {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(tClass);
            criteria.select(criteria.from(tClass));
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }
}