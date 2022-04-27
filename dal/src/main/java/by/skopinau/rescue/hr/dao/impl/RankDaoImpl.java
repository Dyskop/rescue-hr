package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class RankDaoImpl extends BaseDaoImpl<Rank> {
    public RankDaoImpl() {
        super(Rank.class);
    }

    public Rank findByTitle(String rankTitle) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Rank> criteria = cb.createQuery(Rank.class);
            Root<Rank> rank = criteria.from(Rank.class);
            criteria.select(rank)
                    .where(cb.equal(rank.get("rankTitle"), rankTitle));
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList().get(0);
        }
    }
}