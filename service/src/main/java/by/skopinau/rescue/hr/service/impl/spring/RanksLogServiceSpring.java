package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.RanksLog;
import by.skopinau.rescue.hr.repository.RanksLogRepository;
import by.skopinau.rescue.hr.service.RanksLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RanksLogServiceSpring extends BaseServiceSpring<RanksLog> implements RanksLogService {
    private final RanksLogRepository ranksLogRepository;

    @Autowired
    public RanksLogServiceSpring(RanksLogRepository ranksLogRepository) {
        super(ranksLogRepository);
        this.ranksLogRepository = ranksLogRepository;
    }

    public List<RanksLog> findByEmployee(Employee employee) {
        return ranksLogRepository.findByEmployeeOrderByRankGettingDateDesc(employee);
    }

    @Override
    public List<RanksLog> findAll() {
        return ranksLogRepository.findAllOrdered();
    }

    public List<RanksLog> findAllPageable(int page, int size) {
        return ranksLogRepository.findAllOrdered(PageRequest.of(page, size));
    }
}