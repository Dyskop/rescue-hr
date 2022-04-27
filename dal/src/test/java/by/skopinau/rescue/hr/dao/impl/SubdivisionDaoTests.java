package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Subdivision;
import by.skopinau.rescue.hr.util.SessionUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

public class SubdivisionDaoTests {
    private static SubdivisionDaoImpl subdivisionDao;

    @BeforeAll
    static void initTestComponent() {
        subdivisionDao = new SubdivisionDaoImpl();
    }

    @BeforeEach
    void clearDB() {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Subdivision> subdivisionCriteriaDelete = cb.createCriteriaDelete(Subdivision.class);

        employeeCriteriaDelete.from(Employee.class);
        subdivisionCriteriaDelete.from(Subdivision.class);

        session.createQuery(employeeCriteriaDelete).executeUpdate();
        session.createQuery(subdivisionCriteriaDelete).executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void findByTitleTest() {
        // GIVEN
        Subdivision expected = new Subdivision("ПАСЧ-1");
        subdivisionDao.save(expected);

        // WHEN
        Subdivision actual = subdivisionDao.findByTitle("ПАСЧ-1");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getSubdivisionTitle(), actual.getSubdivisionTitle());
        Assertions.assertEquals(expected, actual);
    }
}