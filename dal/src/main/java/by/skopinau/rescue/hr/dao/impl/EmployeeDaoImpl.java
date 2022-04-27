package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> {
    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    public List<Employee> findBySurname(String surname) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("surname"), surname))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    public List<Employee> findByName(String name) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("name"), name))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    public List<Employee> findByPatronymic(String patronymic) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("patronymic"), patronymic))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    public List<Employee> findByBirthday(LocalDate date) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("birthday"), date))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    public List<Employee> findByRank(String rankTitle) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("rank").get("rankTitle"), rankTitle))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    public List<Employee> findByPosition(String positionTitle) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("position").get("positionTitle"), positionTitle))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    public List<Employee> findBySubdivision(String subdivisionTitle) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .where(cb.equal(employee.get("subdivision").get("subdivisionTitle"), subdivisionTitle))
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    @Override
    public List<Employee> findAll() {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
            Root<Employee> employee = criteria.from(Employee.class);
            criteria.select(employee)
                    .orderBy(
                            cb.asc(employee.get("surname")),
                            cb.asc(employee.get("name")),
                            cb.asc(employee.get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }
}