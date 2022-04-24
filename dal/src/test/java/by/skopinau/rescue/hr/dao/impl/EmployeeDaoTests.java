package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.model.Subdivision;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDaoTests {
    private static EmployeeDaoImpl employeeDao;
    private static List<Employee> expected;

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

    @BeforeEach
    void initTestComponent() {
        employeeDao = new EmployeeDaoImpl();
        Employee employee1 = new Employee("Скопинов", "Дмитрий", "Николаевич",
                LocalDate.of(1993, 3, 17),
                new Rank("капитан"),
                new Position("инспектор"),
                new Subdivision("ИНиП"));
        Employee employee2 = new Employee("Иванов", "Иван", "Николаевич",
                LocalDate.of(1995, 3, 17),
                new Rank("рядовой"),
                new Position("пожарный"),
                new Subdivision("ПАСЧ-1"));
        Employee employee3 = new Employee("Петров", "Иван", "Васильевич",
                LocalDate.of(1993, 8, 11),
                new Rank("сержант"),
                new Position("водитель"),
                new Subdivision("ПАСЧ-3"));
        expected = List.of(employee1, employee2, employee3);
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
    }

    @Test
    void findBySurnameTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getSurname().equals("Скопинов"))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findBySurname("Скопинов");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByNameTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getName().equals("Иван"))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findByName("Иван");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByPatronymicTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getPatronymic().equals("Николаевич"))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findByPatronymic("Николаевич");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByBirthdayTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getBirthday().equals(LocalDate.of(1993, 3, 17)))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findByBirthday(LocalDate.of(1993, 3, 17));

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByRankTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getRank().equals(new RankDaoImpl().findByTitle("капитан")))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findByRank("капитан");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByPositionTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getPosition().equals(new PositionDaoImpl().findByTitle("пожарный")))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findByPosition("пожарный");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findBySubdivisionTest() {
        // GIVEN
        expected = expected.stream()
                .filter(employee -> employee.getSubdivision().equals(new SubdivisionDaoImpl().findByTitle("ПАСЧ-3")))
                .sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getPatronymic))
                .collect(Collectors.toList());

        // WHEN
        List<Employee> actual = employeeDao.findBySubdivision("ПАСЧ-3");

        // THEN
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }
}