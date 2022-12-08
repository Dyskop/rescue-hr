package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.PositionsLog;
import by.skopinau.rescue.hr.repository.BaseLogRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.PositionsLogService;
import org.springframework.stereotype.Service;

@Service
public class PositionsLogServiceImpl extends BaseLogServiceImpl<PositionsLog>
        implements PositionsLogService, Pageable<PositionsLog> {
    public PositionsLogServiceImpl(BaseLogRepository<PositionsLog> repository) {
        super(repository);
    }
}