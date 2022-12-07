package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Rank;
import by.skopinau.rescue.hr.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RankService extends BaseService<Rank> implements by.skopinau.rescue.hr.service.RankService {
    private final RankRepository rankRepository;

    @Autowired
    public RankService(RankRepository rankRepository) {
        super(rankRepository);
        this.rankRepository = rankRepository;
    }

    public Rank findByTitle(String rankTitle) {
        return rankRepository.findByRankTitle(rankTitle);
    }
}