package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.RanksLog;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RanksLogDaoImpl extends BaseDaoImpl<RanksLog> {
    public RanksLogDaoImpl() {
        super(RanksLog.class);
    }

    public List<RanksLog> findByEmployee(Employee employee) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<RanksLog> criteria = cb.createQuery(RanksLog.class);
            Root<RanksLog> ranksLog = criteria.from(RanksLog.class);
            criteria.select(ranksLog)
                    .where(cb.equal(ranksLog.get("employee").get("id"), employee.getId()))
                    .orderBy(cb.desc(ranksLog.get("rankGettingDate")));
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }

    @Override
    public List<RanksLog> findAll() {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<RanksLog> criteria = cb.createQuery(RanksLog.class);
            Root<RanksLog> ranksLog = criteria.from(RanksLog.class);
            criteria.select(ranksLog)
                    .orderBy(
                            cb.desc(ranksLog.get("rankGettingDate")),
                            cb.asc(ranksLog.get("employee").get("surname")),
                            cb.asc(ranksLog.get("employee").get("name")),
                            cb.asc(ranksLog.get("employee").get("patronymic"))
                    );
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList();
        }
    }
}