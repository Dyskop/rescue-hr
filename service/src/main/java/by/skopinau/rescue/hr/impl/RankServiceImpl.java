package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.RankDaoImpl;
import by.skopinau.rescue.hr.model.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl extends BaseServiceImpl<Rank> {
    private final RankDaoImpl rankDao;

    @Autowired
    public RankServiceImpl(RankDaoImpl rankDao) {
        super(rankDao);
        this.rankDao = rankDao;
    }

    public Rank findByTitle(String rankTitle) {
        return rankDao.findByTitle(rankTitle);
    }
}