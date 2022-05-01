package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.PositionsLog;

import java.util.List;

public interface PositionsLogDao extends BaseDao<PositionsLog> {
    List<PositionsLog> findByEmployee(Employee employee);

    @Override
    List<PositionsLog> findAll();
}