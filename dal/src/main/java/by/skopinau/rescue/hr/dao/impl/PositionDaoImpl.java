package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class PositionDaoImpl extends BaseDaoImpl<Position> {
    public PositionDaoImpl() {
        super(Position.class);
    }

    public Position findByTitle(String positionTitle) {
        try(Session session = SessionUtil.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Position> criteria = cb.createQuery(Position.class);
            Root<Position> position = criteria.from(Position.class);
            criteria.select(position)
                    .where(cb.equal(position.get("positionTitle"), positionTitle));
            if (session.createQuery(criteria).getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else return session.createQuery(criteria).getResultList().get(0);
        }
    }
}