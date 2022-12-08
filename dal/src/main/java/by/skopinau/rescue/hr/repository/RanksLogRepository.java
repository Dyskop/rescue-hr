package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.RanksLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RanksLogRepository extends BaseLogRepository<RanksLog> {
    List<RanksLog> findByEmployeeOrderByGettingDateDesc(Employee employee);
}