package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.model.State;
import org.springframework.stereotype.Repository;

@Repository
public class StateDaoImpl extends BaseDaoImpl<State> {
    public StateDaoImpl() {
        super(State.class);
    }
}