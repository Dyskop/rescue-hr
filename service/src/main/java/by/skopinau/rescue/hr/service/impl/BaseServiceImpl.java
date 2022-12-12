package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.BaseEntity;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    protected static final int PAGE_SIZE = 10;

    private final BaseRepository<T> repository;

    protected BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Optional<T> save(T entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<T> update(int id, T entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return save(entity);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
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