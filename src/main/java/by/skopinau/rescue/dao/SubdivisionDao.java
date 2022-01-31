package by.skopinau.rescue.dao;

import by.skopinau.rescue.model.SubdivisionEntity;

/**
 * Data Access Object for subdivision.
 */
public interface SubdivisionDao {
    /**
     * Add subdivision
     * @param subdivisionEntity object of SubdivisionEntity
     */
    void save(SubdivisionEntity subdivisionEntity);
}
