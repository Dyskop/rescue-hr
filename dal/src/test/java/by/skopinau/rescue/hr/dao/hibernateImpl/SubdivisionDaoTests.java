package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.model.Subdivision;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Query queryClearEmployee = session.createQuery("DELETE FROM Employee WHERE TRUE");
        Query queryClearSubdivision = session.createQuery("DELETE FROM Subdivision WHERE TRUE");
        queryClearEmployee.executeUpdate();
        queryClearSubdivision.executeUpdate();
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
