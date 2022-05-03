package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.SubdivisionDao;
import by.skopinau.rescue.hr.entity.Subdivision;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SubdivisionDaoJpa extends BaseDaoJpa<Subdivision> implements SubdivisionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public SubdivisionDaoJpa() {
        super(Subdivision.class);
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subdivision> criteria = cb.createQuery(Subdivision.class);
        Root<Subdivision> subdivision = criteria.from(Subdivision.class);
        criteria.select(subdivision)
                .where(cb.equal(subdivision.get("subdivisionTitle"), subdivisionTitle));
        List<Subdivision> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList.get(0);
    }
}