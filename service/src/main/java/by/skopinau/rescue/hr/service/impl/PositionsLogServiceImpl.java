package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import by.skopinau.rescue.hr.repository.PositionsLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionsLogService extends BaseService<PositionsLog> implements by.skopinau.rescue.hr.service.PositionsLogService {
    private final PositionsLogRepository positionsLogRepository;

    @Autowired
    public PositionsLogService(PositionsLogRepository positionsLogRepository) {
        super(positionsLogRepository);
        this.positionsLogRepository = positionsLogRepository;
    }

    public List<PositionsLog> findByEmployee(Employee employee) {
        return positionsLogRepository.findByEmployeeOrderByPositionGettingDateDesc(employee);
    }

    @Override
    public List<PositionsLog> findAll() {
        return positionsLogRepository.findAllOrdered();
    }

    public List<PositionsLog> findAllPageable(int page, int size) {
        return positionsLogRepository.findAllOrdered(PageRequest.of(page, size));
    }
}