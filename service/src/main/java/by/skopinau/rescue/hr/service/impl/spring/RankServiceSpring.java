package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.repository.RankRepository;
import by.skopinau.rescue.hr.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RankServiceSpring extends BaseServiceSpring<Rank> implements RankService {
    private final RankRepository rankRepository;

    @Autowired
    public RankServiceSpring(RankRepository rankRepository) {
        super(rankRepository);
        this.rankRepository = rankRepository;
    }

    public Rank findByTitle(String rankTitle) {
        return rankRepository.findByRankTitle(rankTitle);
    }
}