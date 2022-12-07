package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.BaseEntity;
import by.skopinau.rescue.hr.repository.BaseRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class BaseService<T extends BaseEntity> implements by.skopinau.rescue.hr.service.BaseService<T> {
    private final BaseRepository<T> baseRepository;

    @Autowired
    public BaseService(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public void save(T entity) {
        baseRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        baseRepository.delete(entity);
    }

    public void deleteById(int id) {baseRepository.deleteById(id);}

    @Override
    public T findById(int id) {
        return baseRepository.findById(id).orElseThrow(NoResultException::new);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }
}