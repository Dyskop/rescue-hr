package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.service.SubdivisionService;
import by.skopinau.rescue.hr.dao.SubdivisionDao;
import by.skopinau.rescue.hr.dao.jpa.SubdivisionDaoJpa;
import by.skopinau.rescue.hr.model.Subdivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubdivisionServiceImpl extends BaseServiceImpl<Subdivision> implements SubdivisionService {
    private final SubdivisionDao subdivisionDao;

    @Autowired
    public SubdivisionServiceImpl(SubdivisionDaoJpa subdivisionDao) {
        super(subdivisionDao);
        this.subdivisionDao = subdivisionDao;
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        return subdivisionDao.findByTitle(subdivisionTitle);
    }
}