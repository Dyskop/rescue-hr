package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.model.Subdivision;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> {
    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    public List<Employee> findBySurname(String surname) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where surname = '" + surname + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    public List<Employee> findByName(String name) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where name = '" + name + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    public List<Employee> findByPatronymic(String patronymic) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where patronymic = '" + patronymic + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    public List<Employee> findByBirthday(LocalDate date) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where birthday = '" + date + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    public List<Employee> findByRank(String rankTitle) {
        RankDaoImpl rankDao = new RankDaoImpl();
        Rank byTitle = rankDao.findByTitle(rankTitle);
        int id = byTitle.getId();
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where rank = '" + id + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    public List<Employee> findByPosition(String positionTitle) {
        PositionDaoImpl positionDao = new PositionDaoImpl();
        Position byTitle = positionDao.findByTitle(positionTitle);
        int id = byTitle.getId();
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where position = '" + id + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    public List<Employee> findBySubdivision(String subdivisionTitle) {
        SubdivisionDaoImpl subdivisionDao = new SubdivisionDaoImpl();
        Subdivision byTitle = subdivisionDao.findByTitle(subdivisionTitle);
        int id = byTitle.getId();
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic" +
                    " where subdivision = '" + id + "'", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Employee> query = session.createQuery("select entity from Employee entity order by surname, name, patronymic", Employee.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return query.getResultList();
        }
    }
}
