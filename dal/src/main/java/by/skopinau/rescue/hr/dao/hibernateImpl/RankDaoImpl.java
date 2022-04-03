package by.skopinau.rescue.hr.dao.hibernateImpl;

import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

public class RankDaoImpl extends BaseDaoImpl<Rank> {
    public RankDaoImpl() {
        super(Rank.class);
    }

    public Rank findByTitle(String rank) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Rank> query = session.createQuery("select entity from Rank entity" +
                    " where rankTitle = '" + rank + "'", Rank.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList().get(0);
            }
        }
    }
}
