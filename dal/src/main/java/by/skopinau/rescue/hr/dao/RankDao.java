package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.Rank;

public interface RankDao extends BaseDao<Rank> {
    Rank findByTitle(String rankTitle);
}