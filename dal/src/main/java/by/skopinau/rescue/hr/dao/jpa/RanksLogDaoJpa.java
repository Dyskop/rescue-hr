package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.RanksLogDao;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.RanksLog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RanksLogDaoJpa extends BaseDaoJpa<RanksLog> implements RanksLogDao {
    @PersistenceContext
    private EntityManager entityManager;

    public RanksLogDaoJpa() {
        super(RanksLog.class);
    }

    public List<RanksLog> findByEmployee(Employee employee) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RanksLog> criteria = cb.createQuery(RanksLog.class);
        Root<RanksLog> ranksLog = criteria.from(RanksLog.class);
        criteria.select(ranksLog)
                .where(cb.equal(ranksLog.get("employee").get("id"), employee.getId()))
                .orderBy(cb.desc(ranksLog.get("rankGettingDate")));
        List<RanksLog> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }

    @Override
    public List<RanksLog> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RanksLog> criteria = cb.createQuery(RanksLog.class);
        Root<RanksLog> ranksLog = criteria.from(RanksLog.class);
        criteria.select(ranksLog)
                .orderBy(
                        cb.desc(ranksLog.get("rankGettingDate")),
                        cb.asc(ranksLog.get("employee").get("surname")),
                        cb.asc(ranksLog.get("employee").get("name")),
                        cb.asc(ranksLog.get("employee").get("patronymic"))
                );
        List<RanksLog> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList;
    }
}