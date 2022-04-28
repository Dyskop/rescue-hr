package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.config.OrmConfig;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
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
public class PositionDaoTests {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PositionDaoImpl positionDao;

    @BeforeEach
    void clearDB() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Position> positionCriteriaDelete = cb.createCriteriaDelete(Position.class);

        employeeCriteriaDelete.from(Employee.class);
        positionCriteriaDelete.from(Position.class);

        session.createQuery(employeeCriteriaDelete).executeUpdate();
        session.createQuery(positionCriteriaDelete).executeUpdate();
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