package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.PositionDaoImpl;
import by.skopinau.rescue.hr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends BaseServiceImpl<Position> {
    private final PositionDaoImpl positionDao;

    @Autowired
    public PositionServiceImpl(PositionDaoImpl positionDao) {
        super(positionDao);
        this.positionDao = positionDao;
    }

    public Position findByTitle(String positionTitle) {
        return positionDao.findByTitle(positionTitle);
    }
}
