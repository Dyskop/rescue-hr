package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.entity.Position;

public interface PositionDao extends BaseDao<Position> {
    Position findByTitle(String positionTitle);
}