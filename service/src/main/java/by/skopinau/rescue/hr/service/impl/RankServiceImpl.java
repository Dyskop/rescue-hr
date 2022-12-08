package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Rank;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.service.RankService;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl extends BaseServiceImpl<Rank> implements RankService {
    public RankServiceImpl(BaseRepository<Rank> repository) {
        super(repository);
    }
}