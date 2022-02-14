package by.skopinau.rescue;

import by.skopinau.rescue.dao.UserDaoWithCriteria;
import by.skopinau.rescue.model.EmployeeEntity;
import by.skopinau.rescue.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
    }
}

