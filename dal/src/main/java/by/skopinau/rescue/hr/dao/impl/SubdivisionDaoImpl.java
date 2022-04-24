package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Subdivision;
import by.skopinau.rescue.hr.util.SessionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class SubdivisionDaoImpl extends BaseDaoImpl<Subdivision> {
    public SubdivisionDaoImpl() {
        super(Subdivision.class);
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        try(Session session = SessionUtil.openSession()) {
            TypedQuery<Subdivision> query = session.createQuery("select entity from Subdivision entity" +
                    " where subdivisionTitle = '" + subdivisionTitle + "'", Subdivision.class);
            if (query.getResultList().isEmpty()) {
                throw new NullPointerException("Объекты не существуют");
            } else {
                return query.getResultList().get(0);
            }
        }
    }
}
