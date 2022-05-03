package by.skopinau.rescue.hr.service.impl.jpa;

import by.skopinau.rescue.hr.service.PositionsLogService;
import by.skopinau.rescue.hr.dao.PositionsLogDao;
import by.skopinau.rescue.hr.dao.jpa.PositionsLogDaoJpa;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionsLogServiceJpa extends BaseServiceJpa<PositionsLog> implements PositionsLogService {
    private final PositionsLogDao positionsLogDao;

    @Autowired
    public PositionsLogServiceJpa(PositionsLogDaoJpa positionsLogDao) {
        super(positionsLogDao);
        this.positionsLogDao = positionsLogDao;
    }

    public List<PositionsLog> findByEmployee(Employee employee) {
        return positionsLogDao.findByEmployee(employee);
    }

    @Override
    public List<PositionsLog> findAll() {
        return positionsLogDao.findAll();
    }
}