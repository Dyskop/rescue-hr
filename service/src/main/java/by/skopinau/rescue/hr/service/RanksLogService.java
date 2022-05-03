package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.RanksLog;

import java.util.List;

public interface RanksLogService extends BaseService<RanksLog> {
    List<RanksLog> findByEmployee(Employee employee);

    @Override
    List<RanksLog> findAll();
}