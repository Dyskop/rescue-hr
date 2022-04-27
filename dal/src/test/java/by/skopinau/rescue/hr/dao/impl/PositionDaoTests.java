package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionDaoTests {
    private static PositionDaoImpl positionDao;

    @BeforeAll
    static void initTestComponent() {
        positionDao = new PositionDaoImpl();
    }

    @BeforeEach
    void clearDB() {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Position> positionCriteriaDelete = cb.createCriteriaDelete(Position.class);

        employeeCriteriaDelete.from(Employee.class);
        positionCriteriaDelete.from(Position.class);

        session.createQuery(employeeCriteriaDelete).executeUpdate();
        session.createQuery(positionCriteriaDelete).executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void findByTitleTest() {
        // GIVEN
        Position expected = new Position("пожарный");
        positionDao.save(expected);

        // WHEN
        Position actual = positionDao.findByTitle("пожарный");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getPositionTitle(), actual.getPositionTitle());
        Assertions.assertEquals(expected, actual);
    }
}