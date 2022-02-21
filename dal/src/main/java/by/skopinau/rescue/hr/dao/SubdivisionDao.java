package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.SubdivisionEntity;

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
