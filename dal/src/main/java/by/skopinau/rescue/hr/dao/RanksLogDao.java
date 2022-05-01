package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.RanksLog;

import java.util.List;

public interface RanksLogDao extends BaseDao<RanksLog> {
    List<RanksLog> findByEmployee(Employee employee);

    @Override
    List<RanksLog> findAll();
}