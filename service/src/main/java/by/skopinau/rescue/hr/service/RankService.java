package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.Rank;

public interface RankService extends BaseService<Rank> {
    Rank findByTitle(String rankTitle);
}