package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.RankDao;
import by.skopinau.rescue.hr.entity.Rank;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RankDaoJpa extends BaseDaoJpa<Rank> implements RankDao {
    @PersistenceContext
    private EntityManager entityManager;

    public RankDaoJpa() {
        super(Rank.class);
    }

    public Rank findByTitle(String rankTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rank> criteria = cb.createQuery(Rank.class);
        Root<Rank> rank = criteria.from(Rank.class);
        criteria.select(rank)
                .where(cb.equal(rank.get("rankTitle"), rankTitle));
        List<Rank> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList.get(0);
    }
}