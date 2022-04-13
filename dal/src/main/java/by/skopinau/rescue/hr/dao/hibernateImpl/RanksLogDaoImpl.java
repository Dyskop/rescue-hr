package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.RanksLog;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class RanksLogDaoImpl extends BaseDaoImpl<RanksLog>{
    public RanksLogDaoImpl() {
        super(RanksLog.class);
    }

    public List<RanksLog> findByEmployee(Employee employee) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<RanksLog> query = session.createQuery("select entity from RanksLog entity where" +
                    " employee = '" + employee.getId() + "' order by rankGettingDate desc", RanksLog.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList();
            }
        }
    }

    @Override
    public List<RanksLog> findAll() {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<RanksLog> query = session.createQuery(
                    "select entity from RanksLog entity order by rankGettingDate desc, employee.surname", RanksLog.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return query.getResultList();
        }
    }
}