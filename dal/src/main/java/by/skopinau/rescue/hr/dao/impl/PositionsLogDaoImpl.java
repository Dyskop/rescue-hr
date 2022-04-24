package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.PositionsLog;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
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
            TypedQuery<PositionsLog> query = session.createQuery("select entity from PositionsLog entity where" +
                    " employee = '" + employee.getId() + "' order by positionGettingDate desc", PositionsLog.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    @Override
    public List<PositionsLog> findAll() {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<PositionsLog> query = session.createQuery(
                    "select entity from PositionsLog entity order by positionGettingDate desc, employee.surname", PositionsLog.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return query.getResultList();
        }
    }
}