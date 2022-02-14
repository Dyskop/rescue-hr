package by.skopinau.rescue.dao;

import by.skopinau.rescue.model.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.List;

public class UserDaoWithCriteria {
    private static UserDaoWithCriteria INSTANCE;

    private UserDaoWithCriteria() {
    }

    public static UserDaoWithCriteria getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDaoWithCriteria.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDaoWithCriteria();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Возвращает всех пользователей
     */
    public List<UserEntity> findAll(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);
        criteria.select(criteria.from(UserEntity.class));
        return session.createQuery(criteria).getResultList();
    }
}
