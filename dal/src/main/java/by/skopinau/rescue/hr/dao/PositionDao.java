package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.PositionEntity;

/**
 * Data Access Object for position.
 */
public interface PositionDao {
    /**
     * Add position
     * @param positionEntity object of PositionEntity
     */
    void save(PositionEntity positionEntity);
}
