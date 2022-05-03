package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;

import java.util.List;

public interface PositionsLogDao extends BaseDao<PositionsLog> {
    List<PositionsLog> findByEmployee(Employee employee);

    @Override
    List<PositionsLog> findAll();
}