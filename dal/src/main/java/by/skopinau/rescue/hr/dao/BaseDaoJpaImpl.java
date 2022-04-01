package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.BaseEntity;
import by.skopinau.rescue.hr.util.DynamicEntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BaseDaoJpaImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> tClass;

    public BaseDaoJpaImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public void save(T entity) {
        EntityManager em = DynamicEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        EntityManager em = DynamicEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager em = DynamicEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        T merged = em.merge(entity);
        em.remove(merged);
        em.getTransaction().commit();
    }

    @Override
    public T findById(Long id) {
        EntityManager em = DynamicEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        T entity = em.find(tClass, id);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = DynamicEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<T> query = em.createQuery(
                String.format("select entity from %s entity",
                        tClass.getSimpleName()), tClass);
        em.getTransaction().commit();
        return query.getResultList();
    }
}