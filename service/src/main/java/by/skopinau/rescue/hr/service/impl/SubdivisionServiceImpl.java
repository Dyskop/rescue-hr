package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Subdivision;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.repository.SubdivisionRepository;
import by.skopinau.rescue.hr.service.SubdivisionService;
import org.springframework.stereotype.Service;

@Service
public class SubdivisionServiceImpl extends BaseServiceImpl<Subdivision> implements SubdivisionService {
    public SubdivisionServiceImpl(SubdivisionRepository repository) {
        super(repository);
    }
}