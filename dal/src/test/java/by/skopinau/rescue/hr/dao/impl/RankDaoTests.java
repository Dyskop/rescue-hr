package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.config.OrmConfig;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Rank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = OrmConfig.class)
public class RankDaoTests {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RankDaoImpl rankDao;

    @BeforeEach
    void clearDB() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Rank> rankCriteriaDelete = cb.createCriteriaDelete(Rank.class);

        employeeCriteriaDelete.from(Employee.class);
        rankCriteriaDelete.from(Rank.class);

        session.createQuery(employeeCriteriaDelete).executeUpdate();
        session.createQuery(rankCriteriaDelete).executeUpdate();
    }

    @Test
    void findByTitleTest() {
        // GIVEN
        Rank expected = new Rank("генерал");
        rankDao.save(expected);

        // WHEN
        Rank actual = rankDao.findByTitle("генерал");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getRankTitle(), actual.getRankTitle());
        Assertions.assertEquals(expected, actual);
    }
}