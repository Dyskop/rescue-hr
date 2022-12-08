package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.RanksLogDto;
import by.skopinau.rescue.hr.entity.RanksLog;
import by.skopinau.rescue.hr.mapper.RanksLogMapper;
import by.skopinau.rescue.hr.repository.RanksLogRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.RanksLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RanksLogServiceImpl extends BaseLogServiceImpl<RanksLog>
        implements RanksLogService, Pageable<RanksLog> {
    private final RanksLogRepository ranksLogRepository;
    private final RanksLogMapper mapper;

    @Autowired
    public RanksLogServiceImpl(RanksLogRepository ranksLogRepository, RanksLogMapper mapper) {
        super(ranksLogRepository);
        this.ranksLogRepository = ranksLogRepository;
        this.mapper = mapper;
    }

    //todo:  move to baseLogService, unused
    @Transactional
    public void save(RanksLogDto dto) {
        RanksLog ranksLog = mapper.mapDtoToEntity(dto);
        ranksLogRepository.save(ranksLog);
    }
}