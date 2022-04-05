package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.dao.BaseDao;
import by.skopinau.rescue.hr.model.BaseEntity;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> tClass;

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
            TypedQuery<T> query = session.createQuery(
                    String.format("select entity from %s entity",
                            tClass.getSimpleName()), tClass);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return query.getResultList();
        }
    }
}