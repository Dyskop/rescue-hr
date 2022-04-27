package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.config.Config;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Subdivision;
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
@ContextConfiguration(classes = Config.class)
public class SubdivisionDaoTests {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SubdivisionDaoImpl subdivisionDao;

    @BeforeEach
    void clearDB() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Subdivision> subdivisionCriteriaDelete = cb.createCriteriaDelete(Subdivision.class);

        employeeCriteriaDelete.from(Employee.class);
        subdivisionCriteriaDelete.from(Subdivision.class);

        session.createQuery(employeeCriteriaDelete).executeUpdate();
        session.createQuery(subdivisionCriteriaDelete).executeUpdate();
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