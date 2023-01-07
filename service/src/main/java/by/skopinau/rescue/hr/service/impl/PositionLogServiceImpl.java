package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.PositionLog;
import by.skopinau.rescue.hr.repository.PositionLogRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.PositionLogService;
import org.springframework.stereotype.Service;

@Service
public class PositionLogServiceImpl extends BaseLogServiceImpl<PositionLog>
        implements PositionLogService, Pageable<PositionLog> {
    public PositionLogServiceImpl(PositionLogRepository repository) {
        super(repository);
    }
}