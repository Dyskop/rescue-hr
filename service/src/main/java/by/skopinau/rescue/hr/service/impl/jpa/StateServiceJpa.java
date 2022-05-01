package by.skopinau.rescue.hr.service.impl.jpa;

import by.skopinau.rescue.hr.service.StateService;
import by.skopinau.rescue.hr.dao.jpa.EmployeeDaoJpa;
import by.skopinau.rescue.hr.dao.jpa.StateDaoJpa;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StateServiceJpa extends BaseServiceJpa<State> implements StateService {
    private int actualPositionAmount;
    private final List<Employee> employees;

    @Autowired
    public StateServiceJpa(StateDaoJpa stateDao, EmployeeDaoJpa employeeDao) {
        super(stateDao);
        this.employees = employeeDao.findAll();
    }

    public int getActualPositionAmount(State state) {
        actualPositionAmount = (int) employees.stream()
                .filter(employee -> employee.getPosition().equals(state.getPosition()))
                .filter(employee -> employee.getSubdivision().equals(state.getSubdivision()))
                .count();
        return actualPositionAmount;
    }

    public int getFreePositionAmount(State state) {
        return state.getStateAmount() - actualPositionAmount;
    }
}