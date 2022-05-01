package by.skopinau.rescue.hr.service.impl.jpa;

import by.skopinau.rescue.hr.service.PositionService;
import by.skopinau.rescue.hr.dao.PositionDao;
import by.skopinau.rescue.hr.dao.jpa.PositionDaoJpa;
import by.skopinau.rescue.hr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionServiceJpa extends BaseServiceJpa<Position> implements PositionService {
    private final PositionDao positionDao;

    @Autowired
    public PositionServiceJpa(PositionDaoJpa positionDao) {
        super(positionDao);
        this.positionDao = positionDao;
    }

    public Position findByTitle(String positionTitle) {
        return positionDao.findByTitle(positionTitle);
    }
}