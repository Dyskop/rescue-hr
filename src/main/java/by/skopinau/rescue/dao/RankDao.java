package by.skopinau.rescue.dao;

import by.skopinau.rescue.model.RankEntity;

/**
 * Data Access Object for rank.
 */
public interface RankDao {
    /**
     * Add rank
     * @param rankEntity object of RankEntity
     */
    void save(RankEntity rankEntity);
}
