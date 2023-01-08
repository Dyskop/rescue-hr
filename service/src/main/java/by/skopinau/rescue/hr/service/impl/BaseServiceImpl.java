package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.BaseEntity;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.service.BaseService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "application")
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    protected static final int PAGE_SIZE = 10;

    private final BaseRepository<T> repository;

    protected BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public Optional<T> save(T entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    @Cacheable
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public Optional<T> update(int id, T entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return save(entity);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        }

        return false;
    }

    @Override
    public boolean showPagination() {
        return repository.count() > PAGE_SIZE;
    }

    @Override
    public int getTotalPages() {
        return repository.findAll(Pageable.ofSize(PAGE_SIZE)).getTotalPages();
    }
}