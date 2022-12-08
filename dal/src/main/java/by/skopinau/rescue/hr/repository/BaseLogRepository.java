package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.BaseLogEntity;
import by.skopinau.rescue.hr.entity.Employee;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseLogRepository<T extends BaseLogEntity> extends BaseRepository<T> {
    List<T> findByEmployeeOrderByGettingDateDesc(Employee employee);
}
