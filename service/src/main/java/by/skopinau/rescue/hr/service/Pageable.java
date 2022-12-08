package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.BaseEntity;

import java.util.List;

public interface Pageable<T extends BaseEntity> {
    List<T> findAllPageable(int page, int size);
}
