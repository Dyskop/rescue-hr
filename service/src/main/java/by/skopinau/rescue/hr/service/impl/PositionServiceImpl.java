package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.service.PositionService;
import by.skopinau.rescue.hr.dao.PositionDao;
import by.skopinau.rescue.hr.dao.jpa.PositionDaoJpa;
import by.skopinau.rescue.hr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
    private final PositionDao positionDao;

    @Autowired
    public PositionServiceImpl(PositionDaoJpa positionDao) {
        super(positionDao);
        this.positionDao = positionDao;
    }

    public Position findByTitle(String positionTitle) {
        return positionDao.findByTitle(positionTitle);
    }
}