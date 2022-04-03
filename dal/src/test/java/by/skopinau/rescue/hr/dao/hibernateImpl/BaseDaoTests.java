package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.dao.BaseDao;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.model.Subdivision;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class BaseDaoTests {
    private static BaseDao<Employee> baseDaoWithEmployee;

    @BeforeAll
    static void initTestComponent() {
        baseDaoWithEmployee = new EmployeeDaoImpl();
    }

    @BeforeEach
    void clearDB() {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        Query queryClearEmployee = session.createQuery("DELETE FROM Employee WHERE TRUE");
        Query queryClearRank = session.createQuery("DELETE FROM Rank WHERE TRUE");
        Query queryClearPosition = session.createQuery("DELETE FROM Position WHERE TRUE");
        Query queryClearSubdivision = session.createQuery("DELETE FROM Subdivision WHERE TRUE");
        queryClearEmployee.executeUpdate();
        queryClearRank.executeUpdate();
        queryClearPosition.executeUpdate();
        queryClearSubdivision.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void saveTest() {
        // GIVEN
        Employee expected = new Employee("Скопинов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("капитан"),
                new Position("инспектор"),
                new Subdivision("ИНиП"));

        // WHEN
        baseDaoWithEmployee.save(expected);

        // THEN
        Employee actual = baseDaoWithEmployee.findById(expected.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateTest() {
        // GIVEN
        Employee expected = new Employee("Скопинов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("капитан"),
                new Position("инспектор"),
                new Subdivision("ИНиП"));
        baseDaoWithEmployee.save(expected);

        // WHEN
        expected.setSurname("Иванов");
        baseDaoWithEmployee.update(expected);

        // THEN
        Employee actual = baseDaoWithEmployee.findById(expected.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        // GIVEN
        Employee employee1 = new Employee("Скопинов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("капитан"),
                new Position("инспектор"),
                new Subdivision("ИНиП"));
        Employee employee2 = new Employee("Иванов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("рядовой"),
                new Position("пожарный"),
                new Subdivision("ПАСЧ-1"));
        baseDaoWithEmployee.save(employee1);
        baseDaoWithEmployee.save(employee2);

        // WHEN
        baseDaoWithEmployee.delete(employee1);

        // THEN
        List<Employee> actual = baseDaoWithEmployee.findAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.size(), 1);
    }

    @Test
    void findByIdTest() {
        // GIVEN
        Employee expected = new Employee("Скопинов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("капитан"),
                new Position("инспектор"),
                new Subdivision("ИНиП"));
        baseDaoWithEmployee.save(expected);

        // WHEN
        Employee actual = baseDaoWithEmployee.findById(expected.getId());

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void findAllTest() {
        // GIVEN
        Employee employee1 = new Employee("Скопинов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("капитан"),
                new Position("инспектор"),
                new Subdivision("ИНиП"));
        Employee employee2 = new Employee("Иванов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("рядовой"),
                new Position("пожарный"),
                new Subdivision("ПАСЧ-1"));
        List<Employee> expected = List.of(employee1, employee2);
        baseDaoWithEmployee.save(employee1);
        baseDaoWithEmployee.save(employee2);

        // WHEN
        List<Employee> actual = baseDaoWithEmployee.findAll();

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }
}