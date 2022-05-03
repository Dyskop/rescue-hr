package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.entity.Subdivision;

public interface SubdivisionDao extends BaseDao<Subdivision> {
    Subdivision findByTitle(String subdivisionTitle);
}