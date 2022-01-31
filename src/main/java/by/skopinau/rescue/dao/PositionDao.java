package by.skopinau.rescue.dao;

import by.skopinau.rescue.model.PositionEntity;

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
