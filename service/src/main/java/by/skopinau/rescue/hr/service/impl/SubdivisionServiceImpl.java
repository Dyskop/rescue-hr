package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Subdivision;
import by.skopinau.rescue.hr.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubdivisionService extends BaseService<Subdivision> implements by.skopinau.rescue.hr.service.SubdivisionService {
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionService(SubdivisionRepository subdivisionRepository) {
        super(subdivisionRepository);
        this.subdivisionRepository = subdivisionRepository;
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        return subdivisionRepository.findBySubdivisionTitle(subdivisionTitle);
    }
}