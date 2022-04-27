package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.util.SessionUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

public class RankDaoTests {
    private static RankDaoImpl rankDao;

    @BeforeAll
    static void initTestComponent() {
        rankDao = new RankDaoImpl();
    }

    @BeforeEach
    void clearDB() {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Rank> rankCriteriaDelete = cb.createCriteriaDelete(Rank.class);

        employeeCriteriaDelete.from(Employee.class);
        rankCriteriaDelete.from(Rank.class);

        session.createQuery(employeeCriteriaDelete).executeUpdate();
        session.createQuery(rankCriteriaDelete).executeUpdate();

        session.getTransaction().commit();
        session.close();
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