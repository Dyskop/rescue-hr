package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.PositionDao;
import by.skopinau.rescue.hr.entity.Position;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PositionDaoJpa extends BaseDaoJpa<Position> implements PositionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public PositionDaoJpa() {
        super(Position.class);
    }

    public Position findByTitle(String positionTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Position> criteria = cb.createQuery(Position.class);
        Root<Position> position = criteria.from(Position.class);
        criteria.select(position)
                .where(cb.equal(position.get("positionTitle"), positionTitle));
        List<Position> resultList = entityManager.createQuery(criteria).getResultList();
        if (resultList.isEmpty()) {
            throw new NullPointerException("Объекты не существуют");
        } else return resultList.get(0);
    }
}