package by.skopinau.rescue.hr.service.impl.jpa;

import by.skopinau.rescue.hr.service.RanksLogService;
import by.skopinau.rescue.hr.dao.RanksLogDao;
import by.skopinau.rescue.hr.dao.jpa.RanksLogDaoJpa;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.RanksLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RanksLogServiceJpa extends BaseServiceJpa<RanksLog> implements RanksLogService {
    private final RanksLogDao ranksLogDao;

    @Autowired
    public RanksLogServiceJpa(RanksLogDaoJpa ranksLogDao) {
        super(ranksLogDao);
        this.ranksLogDao = ranksLogDao;
    }

    public List<RanksLog> findByEmployee(Employee employee) {
        return ranksLogDao.findByEmployee(employee);
    }

    @Override
    public List<RanksLog> findAll() {
        return ranksLogDao.findAll();
    }
}