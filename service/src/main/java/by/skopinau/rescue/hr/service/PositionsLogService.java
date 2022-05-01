package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.PositionsLog;

import java.util.List;

public interface PositionsLogService extends BaseService<PositionsLog> {
    List<PositionsLog> findByEmployee(Employee employee);

    @Override
    List<PositionsLog> findAll();
}