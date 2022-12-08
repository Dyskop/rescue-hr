package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionsLogRepository extends BaseLogRepository<PositionsLog> {
    List<PositionsLog> findByEmployeeOrderByGettingDateDesc(Employee employee);
}