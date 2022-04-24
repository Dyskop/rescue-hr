package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.PositionsLogDaoImpl;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.PositionsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsLogServiceImpl extends BaseServiceImpl<PositionsLog> {
    private final PositionsLogDaoImpl positionsLogDao;

    @Autowired
    public PositionsLogServiceImpl(PositionsLogDaoImpl positionsLogDao) {
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