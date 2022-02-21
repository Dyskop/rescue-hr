package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(UserEntity userEntity) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        UserEntity userEntity = (UserEntity) currentSession.createQuery("select '*' from UserEntity");
        return userEntity;
    }
}
