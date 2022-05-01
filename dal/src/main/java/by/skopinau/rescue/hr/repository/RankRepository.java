package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.model.Rank;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends BaseRepository<Rank> {
    Rank findByRankTitle(String rankTitle);
}