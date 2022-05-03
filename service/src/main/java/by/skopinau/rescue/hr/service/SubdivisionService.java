package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.Subdivision;

public interface SubdivisionService extends BaseService<Subdivision> {
    Subdivision findByTitle(String subdivisionTitle);
}