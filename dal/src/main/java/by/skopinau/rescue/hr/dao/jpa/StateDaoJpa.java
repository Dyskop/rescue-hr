package by.skopinau.rescue.hr.dao.jpa;

import by.skopinau.rescue.hr.dao.StateDao;
import by.skopinau.rescue.hr.model.State;
import org.springframework.stereotype.Repository;

@Repository
public class StateDaoJpa extends BaseDaoJpa<State> implements StateDao {
    public StateDaoJpa() {
        super(State.class);
    }
}