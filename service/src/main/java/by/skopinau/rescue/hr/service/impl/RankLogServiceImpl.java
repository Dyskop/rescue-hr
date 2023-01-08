package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.RankLogDto;
import by.skopinau.rescue.hr.entity.RankLog;
import by.skopinau.rescue.hr.mapper.RankLogMapper;
import by.skopinau.rescue.hr.repository.RankLogRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.RankLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames = "application")
public class RankLogServiceImpl extends BaseLogServiceImpl<RankLog>
        implements RankLogService, Pageable<RankLog> {
    private final RankLogRepository repository;
    private final RankLogMapper mapper;

    @Autowired
    public RankLogServiceImpl(RankLogRepository repository, RankLogMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    //todo:  move to baseLogService, unused
    @Transactional
    @CacheEvict(allEntries = true)
    public void save(RankLogDto dto) {
        RankLog rankLog = mapper.mapDtoToEntity(dto);
        repository.save(rankLog);
    }
}