package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.SubdivisionDaoImpl;
import by.skopinau.rescue.hr.model.Subdivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubdivisionServiceImpl extends BaseServiceImpl<Subdivision> {
    private final SubdivisionDaoImpl subdivisionDao;

    @Autowired
    public SubdivisionServiceImpl(SubdivisionDaoImpl subdivisionDao) {
        super(subdivisionDao);
        this.subdivisionDao = subdivisionDao;
    }

    public Subdivision findByTitle(String subdivisionTitle) {
        return subdivisionDao.findByTitle(subdivisionTitle);
    }
}
