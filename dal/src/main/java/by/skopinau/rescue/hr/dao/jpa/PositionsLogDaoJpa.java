package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.PositionsLogDao;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PositionsLogDaoJpa extends BaseDaoJpa<PositionsLog> implements PositionsLogDao {
    @PersistenceContext
    private EntityManager entityManager;

    public PositionsLogDaoJpa() {
        super(PositionsLog.class);
    }

    public List<PositionsLog> findByEmployee(Employee employee) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PositionsLog> criteria = cb.createQuery(PositionsLog.class);
        Root<PositionsLog> positionsLog = criteria.from(PositionsLog.class);
        criteria.select(positionsLog)
                .where(cb.equal(positionsLog.get("employee").get("id"), employee.getId()))
                .orderBy(cb.desc(positionsLog.get("positionGettingDate")));
        List<PositionsLog> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    @Override
    public List<PositionsLog> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PositionsLog> criteria = cb.createQuery(PositionsLog.class);
        Root<PositionsLog> positionsLog = criteria.from(PositionsLog.class);
        criteria.select(positionsLog)
                .orderBy(
                        cb.desc(positionsLog.get("positionGettingDate")),
                        cb.asc(positionsLog.get("employee").get("surname")),
                        cb.asc(positionsLog.get("employee").get("name")),
                        cb.asc(positionsLog.get("employee").get("patronymic"))
                );
        List<PositionsLog> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }
}