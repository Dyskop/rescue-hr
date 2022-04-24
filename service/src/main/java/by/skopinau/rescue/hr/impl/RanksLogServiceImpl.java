package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.RanksLogDaoImpl;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.RanksLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RanksLogServiceImpl extends BaseServiceImpl<RanksLog> {
    private final RanksLogDaoImpl ranksLogDao;

    @Autowired
    public RanksLogServiceImpl(RanksLogDaoImpl ranksLogDao) {
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