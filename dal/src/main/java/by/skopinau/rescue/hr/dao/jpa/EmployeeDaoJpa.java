package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.EmployeeDao;
import by.skopinau.rescue.hr.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDaoJpa extends BaseDaoJpa<Employee> implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDaoJpa() {
        super(Employee.class);
    }

    public List<Employee> findBySurname(String surname) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("surname"), surname))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("name"), name))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByPatronymic(String patronymic) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("patronymic"), patronymic))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByBirthday(LocalDate date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("birthday"), date))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByRank(Rank rank) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("rank"), rank))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByPosition(Position position) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("position"), position))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findBySubdivision(Subdivision subdivision) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("subdivision"), subdivision))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByRankTitle(String rankTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("rank").get("rankTitle"), rankTitle))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByPositionTitle(String positionTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("position").get("positionTitle"), positionTitle))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findBySubdivisionTitle(String subdivisionTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("subdivision").get("subdivisionTitle"), subdivisionTitle))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    public List<Employee> findByState(State state) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .where(cb.equal(employee.get("position"), state.getPosition()),
                        cb.equal(employee.get("subdivision"), state.getSubdivision()))
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    @Override
    public List<Employee> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);
        criteria.select(employee)
                .orderBy(
                        cb.asc(employee.get("surname")),
                        cb.asc(employee.get("name")),
                        cb.asc(employee.get("patronymic"))
                );
        List<Employee> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }
}