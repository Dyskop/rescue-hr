package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.Subdivision;
import by.skopinau.rescue.hr.repository.SubdivisionRepository;
import by.skopinau.rescue.hr.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubdivisionServiceSpring extends BaseServiceSpring<Subdivision> implements SubdivisionService {
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionServiceSpring(SubdivisionRepository subdivisionRepository) {
        super(subdivisionRepository);
        this.subdivisionRepository = subdivisionRepository;
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        return subdivisionRepository.findBySubdivisionTitle(subdivisionTitle);
    }
}