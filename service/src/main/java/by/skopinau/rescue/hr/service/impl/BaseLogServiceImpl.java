package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.BaseLogEntity;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.repository.BaseLogRepository;
import by.skopinau.rescue.hr.service.BaseLogService;
import by.skopinau.rescue.hr.service.Pageable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@CacheConfig(cacheNames = "application")
public abstract class BaseLogServiceImpl<T extends BaseLogEntity> extends BaseServiceImpl<T>
        implements BaseLogService<T>, Pageable<T> {
    private final BaseLogRepository<T> repository;

    public BaseLogServiceImpl(BaseLogRepository<T> repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Cacheable
    public List<T> findByEmployee(Employee employee) {
        return repository.findByEmployeeOrderByGettingDateDesc(employee);
    }

    @Override
    @Cacheable
    public List<T> findAllPageable(int page) {
        return repository.findAll(PageRequest
                        .of(page, PAGE_SIZE, Sort.by("gettingDate", "id"))).toList();
    }
}
