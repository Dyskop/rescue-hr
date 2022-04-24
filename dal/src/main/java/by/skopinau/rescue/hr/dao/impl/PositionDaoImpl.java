package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PositionDaoImpl extends BaseDaoImpl<Position> {
    public PositionDaoImpl() {
        super(Position.class);
    }

    public Position findByTitle(String positionTitle) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Position> query = session.createQuery("select entity from Position entity" +
                    " where positionTitle = '" + positionTitle + "'", Position.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList().get(0);
            }
        }
    }
}
