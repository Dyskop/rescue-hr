package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.config.OrmConfig;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Subdivision;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = OrmConfig.class)
public class SubdivisionDaoTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SubdivisionDaoJpa subdivisionDao;

    @BeforeEach
    void clearDB() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaDelete<Employee> employeeCriteriaDelete = cb.createCriteriaDelete(Employee.class);
        CriteriaDelete<Subdivision> subdivisionCriteriaDelete = cb.createCriteriaDelete(Subdivision.class);

        employeeCriteriaDelete.from(Employee.class);
        subdivisionCriteriaDelete.from(Subdivision.class);

        entityManager.createQuery(employeeCriteriaDelete).executeUpdate();
        entityManager.createQuery(subdivisionCriteriaDelete).executeUpdate();
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