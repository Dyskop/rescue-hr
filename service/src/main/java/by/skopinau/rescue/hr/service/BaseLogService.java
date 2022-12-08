package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.BaseLogEntity;
import by.skopinau.rescue.hr.entity.Employee;

import java.util.List;

public interface BaseLogService<T extends BaseLogEntity> extends BaseService<T>, Pageable<T> {
    List<T> findByEmployee(Employee employee);
}
