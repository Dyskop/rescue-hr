package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.model.BaseEntity;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.service.BaseService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseServiceSpring<T extends BaseEntity> implements BaseService<T> {
    private final BaseRepository<T> baseRepository;

    @Autowired
    public BaseServiceSpring(BaseRepository<T> baseRepository) {
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

    @Override
    public T findById(int id) {
        return baseRepository.findById(id).orElseThrow(NoResultException::new);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }
}