package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {
}