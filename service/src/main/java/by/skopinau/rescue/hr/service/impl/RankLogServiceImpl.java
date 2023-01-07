package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.RankLogDto;
import by.skopinau.rescue.hr.entity.RankLog;
import by.skopinau.rescue.hr.mapper.RanksLogMapper;
import by.skopinau.rescue.hr.repository.RankLogRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.RankLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RankLogServiceImpl extends BaseLogServiceImpl<RankLog>
        implements RankLogService, Pageable<RankLog> {
    private final RankLogRepository repository;
    private final RanksLogMapper mapper;

    @Autowired
    public RankLogServiceImpl(RankLogRepository repository, RanksLogMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    //todo:  move to baseLogService, unused
    @Transactional
    public void save(RankLogDto dto) {
        RankLog rankLog = mapper.mapDtoToEntity(dto);
        repository.save(rankLog);
    }
}