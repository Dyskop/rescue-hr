package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.Query;
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
        Query queryClearEmployee = session.createQuery("DELETE FROM Employee WHERE TRUE");
        Query queryClearPosition = session.createQuery("DELETE FROM Position WHERE TRUE");
        queryClearEmployee.executeUpdate();
        queryClearPosition.executeUpdate();
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
