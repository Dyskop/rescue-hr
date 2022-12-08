package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.BaseLogEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseLogRepository<T extends BaseLogEntity> extends BaseRepository<T> {
}
