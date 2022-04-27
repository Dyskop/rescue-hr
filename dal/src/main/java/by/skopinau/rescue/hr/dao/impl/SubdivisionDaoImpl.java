package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.Subdivision;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class SubdivisionDaoImpl extends BaseDaoImpl<Subdivision> {
    public SubdivisionDaoImpl() {
        super(Subdivision.class);
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        Session session = getSessionFactory().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Subdivision> criteria = cb.createQuery(Subdivision.class);
        Root<Subdivision> subdivision = criteria.from(Subdivision.class);
        criteria.select(subdivision)
                .where(cb.equal(subdivision.get("subdivisionTitle"), subdivisionTitle));
        if (session.createQuery(criteria).getResultList().isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return session.createQuery(criteria).getResultList().get(0);
    }
}