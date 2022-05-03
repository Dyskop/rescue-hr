package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import by.skopinau.rescue.hr.repository.PositionsLogRepository;
import by.skopinau.rescue.hr.service.PositionsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionsLogServiceSpring extends BaseServiceSpring<PositionsLog> implements PositionsLogService {
    private final PositionsLogRepository positionsLogRepository;

    @Autowired
    public PositionsLogServiceSpring(PositionsLogRepository positionsLogRepository) {
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
}