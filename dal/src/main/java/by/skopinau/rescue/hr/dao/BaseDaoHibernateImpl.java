package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.BaseEntity;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class BaseDaoHibernateImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> tClass;

    public BaseDaoHibernateImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public void save(T entity) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        session.save(entity);
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
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T findById(Long id) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        T entity = session.find(tClass, id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        TypedQuery<T> query = session.createQuery(
                String.format("select entity from %s entity",
                        tClass.getSimpleName()), tClass);
        session.getTransaction().commit();
        return query.getResultList();
    }
}
