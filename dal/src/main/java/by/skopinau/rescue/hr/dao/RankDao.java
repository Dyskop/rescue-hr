package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.entity.Rank;

public interface RankDao extends BaseDao<Rank> {
    Rank findByTitle(String rankTitle);
}