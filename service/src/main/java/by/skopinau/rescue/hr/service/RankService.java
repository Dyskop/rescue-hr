package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.model.Rank;

public interface RankService extends BaseService<Rank> {
    Rank findByTitle(String rankTitle);
}