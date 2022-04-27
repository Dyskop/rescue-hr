package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.PositionsLog;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionsLogDaoImpl extends BaseDaoImpl<PositionsLog> {
    public PositionsLogDaoImpl() {
        super(PositionsLog.class);
    }

    public List<PositionsLog> findByEmployee(Employee employee) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PositionsLog> criteria = cb.createQuery(PositionsLog.class);
            Root<PositionsLog> positionsLog = criteria.from(PositionsLog.class);
            criteria.select(positionsLog)
                    .where(cb.equal(positionsLog.get("employee").get("id"), employee.getId()))
                    .orderBy(cb.desc(positionsLog.get("positionGettingDate")));
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    @Override
    public List<PositionsLog> findAll() {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PositionsLog> criteria = cb.createQuery(PositionsLog.class);
            Root<PositionsLog> positionsLog = criteria.from(PositionsLog.class);
            criteria.select(positionsLog)
                    .orderBy(
                            cb.desc(positionsLog.get("positionGettingDate")),
                            cb.asc(positionsLog.get("employee").get("surname")),
                            cb.asc(positionsLog.get("employee").get("name")),
                            cb.asc(positionsLog.get("employee").get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }
}